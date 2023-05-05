package ch.ethz.systems.netbench.xpt.ports.PACKS;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;

public class PACKSOutputPort extends OutputPort {

    private boolean ecnMarking;
    private long ecnThresholdPackets;

    public PACKSOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, long numberQueues, int sizePerQueue, String mappingType, int windowSize, int sampleCount, float kValue, boolean ecnMarking, long ecnThresholdPackets) {
        super(ownNetworkDevice, targetNetworkDevice, link, new PACKSQueue(numberQueues, sizePerQueue, ownNetworkDevice, mappingType, windowSize, sampleCount, kValue));
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
    }

    /**
     * Enqueue the given packet.
     * To control droppings
     * There is no guarantee that the packet is actually sent,
     * as the queue buffer's limit might be reached.
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
        // so this packet can be immediately sent
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

                // Update buffer size with enqueued packet
                increaseBufferOccupiedBits(packet.getSizeBit());
                getLogger().logQueueState(getQueue().size(), getBufferOccupiedBits());

            } else {

                // Logging dropped packet
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
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
