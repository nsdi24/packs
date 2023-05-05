package ch.ethz.systems.netbench.xpt.ports.SPPIFO_WFQ;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;


public class WFQSPPIFOOutputPort extends OutputPort {

    private boolean ecnMarking;
    private long ecnThresholdPackets;

    public WFQSPPIFOOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, long numberQueues, long sizePerQueuePackets, boolean ecnMarking, long ecnThresholdPackets) {
        super(ownNetworkDevice, targetNetworkDevice, link, new WFQSPPIFOQueue(numberQueues, sizePerQueuePackets));
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
    }

    /**
     * Enqueue the given packet.
     * Drops it if the queue is full (tail drop).
     *
     * @param packet    Packet instance
     */
    @Override
    public void enqueue(Packet packet) {

        // ECN: Mark congestion flag if size of the queue is too big
        if (this.ecnMarking) {
            if (this.getQueue().size() >= this.ecnThresholdPackets) {
                ((IpHeader) packet).markCongestionEncountered();
            }
        }

        // If it is not sending, then the queue is empty at the moment,
        // so this packet can be immediately send
        if (!getIsSending()) {

            // Link is now being utilized
            getLogger().logLinkUtilized(true);

            // Add event when sending is finished
            Simulator.registerEvent(new PacketDispatchedEvent(
                    (long)((double)packet.getSizeBit() / getLink().getBandwidthBitPerNs()),
                    packet,
                    this
            ));

            // It is now sending again
            setIsSending();

        } else { // If it is still sending, the packet is added to the queue, making it non-empty

            boolean enqueued = false;
            enqueued = getQueue().offer(packet);


            if (enqueued){
                increaseBufferOccupiedBits(packet.getSizeBit());
                getLogger().logQueueState(getQueue().size(), getBufferOccupiedBits());
            } else {
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");

                // Convert to IP packet
                IpHeader ipHeader = (IpHeader) packet;
                if (ipHeader.getSourceId() == this.getOwnId()) {
                    SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
                }
                // Tracking drops per rank (above only tracks drops)
                if (SimulationLogger.hasDropsTrackingEnabled()){
                    if (packet.isTCP()){
                        SimulationLogger.logDropsPerRank(this.getOwnId(), (int)((FullExtTcpPacket)packet).getPriority(), 1);
                    } else {
                        SimulationLogger.logDropsPerRank(this.getOwnId(), (int)((FullExtUdpPacket)packet).getPriority(), 1);
                    }
                }
            }
        }
    }
}
