package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.network.Socket;
import ch.ethz.systems.netbench.core.network.TransportLayer;

public abstract class AIFOSocket extends Socket {

    private int sourcePort;
    private int destinationPort;

    /**
     * Create a socket. By default, it should be the receiver.
     * Use the {@link #start() start} method to make the socket a
     * sender and initiate the communication handshake.
     *
     * @param transportLayer    Transport layer
     * @param sourceId          Source network device identifier
     * @param destinationId     Target network device identifier
     * @param flowSizeByte      Size of the flow in bytes
     */
    public AIFOSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte);
    }

    public AIFOSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte, int sourcePort, int destinationPort) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte);
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;

        // Initialize logger
        // we don't need to log info for udp
        this.setPrivateLogger(new AIFOFlowLogger(flowId, sourceId, destinationId, flowSizeByte, sourcePort, destinationPort));

    }

    public AIFOSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId, long flowSizeByte, boolean udpException, long realFlowSizeByte, int sourcePort, int destinationPort) {
        super(transportLayer, flowId, sourceId, destinationId, flowSizeByte);
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;

        // Initialize logger
        // we don't need to log info for udp
        this.setPrivateLogger(new AIFOFlowLogger(flowId, sourceId, destinationId, flowSizeByte, udpException, realFlowSizeByte, sourcePort, destinationPort));

    }

    protected void confirmFlowUdp(long newlyConfirmedFlowByte) {
        this.getPrivateLogger().logFlowAcknowledged(newlyConfirmedFlowByte);
        // TODO: Cleanup socket
    }

    public int getSourcePort() { return this.sourcePort; }
    public int getDestinationPort() { return this.destinationPort; }

}
