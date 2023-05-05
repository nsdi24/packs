package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;

public class AIFOUDPSocket extends AIFOSocket {

    // Maximum segment size (MSS) (data carried by a UDP packet);
    private static final long MAX_SEGMENT_SIZE = 1380L / 4;

    private static final long FIRST_SEQ_NUMBER = 0;
    private long sendNextNumber; //  Next sequence number to be used

    public AIFOUDPSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte);
        this.sendNextNumber = FIRST_SEQ_NUMBER;
    }

    public AIFOUDPSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte, long realFlowSizeByte) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte, true, realFlowSizeByte, 80, 80);
        this.sendNextNumber = FIRST_SEQ_NUMBER;
    }

    public AIFOUDPSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte, int sourcePort, int destinationPort) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte, sourcePort, destinationPort);
        this.sendNextNumber = FIRST_SEQ_NUMBER;
    }

    public AIFOUDPSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte, long realFlowSizeByte, int sourcePort, int destinationPort) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte, true, realFlowSizeByte, sourcePort, destinationPort);
        this.sendNextNumber = FIRST_SEQ_NUMBER;
    }

    /**
     * Makes the socket a sender and initiates the communication.
     */
    @Override
    public void start() {
        // Send packets until there is no longer any flow to send
        long amountToSendByte = getFlowSizeByte(sendNextNumber);
        long seq = sendNextNumber;
        sendNextNumber += amountToSendByte;

        FullExtUdpPacket packet = createPacket(amountToSendByte);
        SimulationLogger.increaseStatisticCounter("UDP_PACKET_SENT");
        transportLayer.send(packet);

        if (seq < flowSizeByte) {
            Simulator.registerEvent(new AIFOUDPSendPacketEvent(12000 / 4 * 10 * 4, this));
        }
    }

    /**
     * Determine the flow size desired for the given sequence number.
     *
     * @param seq   Sequence number
     *
     * @return Flow size in bytes
     */
    protected long getFlowSizeByte(long seq) {
        return Math.min(MAX_SEGMENT_SIZE, flowSizeByte - seq);
    }

    /**
     * Used by the receiver to process packets. We don't do much
     */
    @Override
    public void handle(Packet genericPacket) {
        FullExtUdpPacket packet = (FullExtUdpPacket) genericPacket;
        long size = packet.getDataSizeByte();

        if (this.isReceiver()) {
            this.confirmFlowUdp(size);
        }
        SimulationLogger.increaseStatisticCounter("UDP_PACKETS_RECEIVED"); // This just does + 1 (since length not added)
    }

    /**
     * Create a UDP packet.
     *
     * @param dataSizeByte      Data size carried in bytes
     *
     * @return  UDP packet instance
     */
    protected FullExtUdpPacket createPacket(long dataSizeByte) {
        return new FullExtUdpPacket(
                flowId, dataSizeByte, sourceId, destinationId,
                100, this.getSourcePort(), this.getDestinationPort(),
                0, 0, 2000000000);
    }
}
