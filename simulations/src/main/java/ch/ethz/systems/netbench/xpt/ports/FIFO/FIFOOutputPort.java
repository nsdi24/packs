package ch.ethz.systems.netbench.xpt.ports.FIFO;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;
import ch.ethz.systems.netbench.ext.basic.IpPacket;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;

public class FIFOOutputPort extends OutputPort {

    private final int maxQueueSize;
    private boolean ecnMarking;
    private long ecnThresholdPackets;

    FIFOOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, int maxQueueSize, boolean ecnMarking, long ecnThresholdPackets) {
        super(ownNetworkDevice, targetNetworkDevice, link, new FIFOQueue<Packet>(maxQueueSize, ownNetworkDevice.getIdentifier()));
        this.maxQueueSize = maxQueueSize;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
    }

    /**
     * Enqueue the given packet.
     * Drops it if the queue is full (tail drop).
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
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => Packet sent (no queue): SeqNo: " + pk.getSequenceNumber() + ", ACKNo: " + pk.getAcknowledgementNumber() + ", Priority: "+ pk.getPriority());
                } else {
                    FullExtUdpPacket pk = (FullExtUdpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => Packet sent (no queue): Priority: "+ pk.getPriority());
                }
            }

        } else { // If it is still sending, the packet is added to the queue (if there is space)

            // Log packet for debugging
            if(SimulationLogger.hasPacketsTrackingEnabled()) {
                if (packet.isTCP()){
                    FullExtTcpPacket pk = (FullExtTcpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => Packet enqueued: SeqNo: " + pk.getSequenceNumber() + ", ACKNo: " + pk.getAcknowledgementNumber() + ", Priority: " + pk.getPriority());
                } else {
                    FullExtUdpPacket pk = (FullExtUdpPacket)packet;
                    SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => Packet enqueued: Priority: " + pk.getPriority());
                }
            }

            // We tag the enqueue time to the packet, before offering it to FIFO
            packet.setEnqueueTime(Simulator.getCurrentTime());

            // Tail-drop enqueue
            if (getQueueSize() <= maxQueueSize-1) {

                // Enqueue to the FIFO queue
                getQueue().add(packet);

                // Update buffer size with enqueued packet
                increaseBufferOccupiedBits(packet.getSizeBit());
                getLogger().logQueueState(getQueue().size(), getBufferOccupiedBits());

            } else {

                // Log packet (and queue state) for debugging
                if(SimulationLogger.hasPacketsTrackingEnabled()){

                    /* Debug drops */
                    String message = "FIFO Queue: [";
                    Object[] contentFIFO = getQueue().toArray();
                    for (int j = 0; j<contentFIFO.length; j++){
                        Packet pFIFO = (Packet)contentFIFO[j];
                        if (pFIFO.isTCP()){
                            message = message + ((FullExtTcpPacket)pFIFO).getPriority() + "(" + pFIFO.getEnqueueTime() + ") , ";
                        } else {
                            message = message + ((FullExtUdpPacket)pFIFO).getPriority() + "(" + pFIFO.getEnqueueTime() + ") , ";
                        }
                    }
                    message = message + "]\n";

                    if (packet.isTCP()){
                        message = message + "TCP Packet dropped: " + ((FullExtTcpPacket)packet).getPriority() + "(" + packet.getEnqueueTime() + ")";
                    } else {
                        message = message + "UDP Packet dropped: " + ((FullExtUdpPacket)packet).getPriority() + "(" + packet.getEnqueueTime() + ")";
                    }

                    SimulationLogger.logPacket(message);
                }

                // Logging dropped packet
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
                IpPacket p = (IpPacket) packet;
                if (p.getSourceId() == this.getOwnId()) {
                    SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
                }

                // Tracking drops per rank (above only tracks drops)
                if (SimulationLogger.hasDropsTrackingEnabled()) {
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
