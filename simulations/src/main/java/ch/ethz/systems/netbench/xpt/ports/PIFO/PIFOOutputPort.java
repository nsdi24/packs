package ch.ethz.systems.netbench.xpt.ports.PIFO;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;


public class PIFOOutputPort extends OutputPort {

    private boolean ecnMarking;
    private long ecnThresholdPackets;

    public PIFOOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, long maxQueueSize, boolean ecnMarking, long ecnThresholdPackets) {
        super(ownNetworkDevice, targetNetworkDevice, link, new PIFOQueue(maxQueueSize));
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
    }

    /**
     * Enqueue the given packet.
     * There is no guarantee that the packet is actually sent,
     * as the queue buffer's limit might be reached. If the limit is reached,
     * the packet with lower priority (higher rank) is dropped.
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

            // Log packet for debugging
            if(SimulationLogger.hasPacketsTrackingEnabled()){
                if (packet.isTCP()){
                    FullExtTcpPacket pk = (FullExtTcpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => TCP Packet sent (no queue): SeqNo: " + pk.getSequenceNumber() + ", ACKNo: " + pk.getAcknowledgementNumber() + ", Priority: "+ pk.getPriority());
                } else {
                    FullExtUdpPacket pk = (FullExtUdpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => UDP Packet sent (no queue): Priority: "+ pk.getPriority());
                }
            }

        } else { // If it is still sending, the packet is added to the queue, making it non-empty

            // Log packet for debugging
            if(SimulationLogger.hasPacketsTrackingEnabled()) {
                if (packet.isTCP()){
                    FullExtTcpPacket pk = (FullExtTcpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => TCP Packet enqueued: SeqNo: " + pk.getSequenceNumber() + ", ACKNo: " + pk.getAcknowledgementNumber() + ", Priority: " + pk.getPriority());
                } else {
                    FullExtUdpPacket pk = (FullExtUdpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => TCP Packet enqueued: Priority: "+ pk.getPriority());
                }
            }

            // Enqueue to the PIFO queue
            PIFOQueue pq = (PIFOQueue) getQueue();
            Packet droppedPacket = (Packet)pq.offerPacket(packet);

            // Update buffer size with enqueued packet
            increaseBufferOccupiedBits(packet.getSizeBit());
            getLogger().logQueueState(pq.size(), getBufferOccupiedBits());

            if (droppedPacket != null) {

                // Update buffer size with dropped packet
                decreaseBufferOccupiedBits(droppedPacket.getSizeBit());
                getLogger().logQueueState(pq.size(), getBufferOccupiedBits());

                // Logging dropped packet
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
                IpHeader ipHeader = (IpHeader) droppedPacket;
                if (ipHeader.getSourceId() == this.getOwnId()) {
                    SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
                }

                // Tracking drops per rank (above only tracks drops)
                if (SimulationLogger.hasDropsTrackingEnabled()){
                    if (droppedPacket.isTCP()){
                        SimulationLogger.logDropsPerRank(this.getOwnId(), (int)((FullExtTcpPacket)droppedPacket).getPriority(), 1);
                    } else {
                        SimulationLogger.logDropsPerRank(this.getOwnId(), (int)((FullExtUdpPacket)droppedPacket).getPriority(), 1);
                    }
                }
            }
        }
    }


}
