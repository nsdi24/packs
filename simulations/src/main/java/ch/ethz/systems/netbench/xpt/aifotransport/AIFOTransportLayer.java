package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.core.network.Socket;
import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.ext.basic.IpPacket;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;

public abstract class AIFOTransportLayer extends TransportLayer {

    public boolean udpException = false;

    public AIFOTransportLayer(int identifier) {
        super(identifier);
    }

    @Override
    public void receive(Packet genericPacket) {

        IpPacket packet = (IpPacket) genericPacket;
        FullExtTcpPacket fetPacket = (FullExtTcpPacket) genericPacket;
        Socket socket = this.getFlowIdToSocket().get(packet.getFlowId());

        // If the socket does not yet exist, it is an incoming socket
        if (socket == null && !this.getFinishedFlowIds().contains(packet.getFlowId())) {

            // Create the socket instance in the other direction
            if (fetPacket.getFlowSizeByte() == -1) {
                socket = createSocketWithPort(packet.getFlowId(), packet.getSourceId(), -1, fetPacket.getSourcePort(), fetPacket.getDestinationPort());
            }
            else {
                socket = createSocketWithPortAndRealFlowSize(packet.getFlowId(), packet.getSourceId(), -1, fetPacket.getFlowSizeByte(), fetPacket.getSourcePort(), fetPacket.getDestinationPort());
            }
            this.getFlowIdToReceiver().put(packet.getFlowId(), this);
            this.getFlowIdToSocket().put(packet.getFlowId(), socket);
        }

        // Give packet to socket (we do not care about stray packets)
        if (socket != null) {
            socket.handle(packet);
        }

    }

    @Override
    public void startFlow(int destination, long flowSizeByte) {

        // Create new outgoing socket
        Socket socket;
        if (this.udpException == true) {
            socket = createSocketWithRealFlowSize(this.getFlowIdCounter(), destination, flowSizeByte, flowSizeByte);
        }
        else {
            socket = createSocket(this.getFlowIdCounter(), destination, flowSizeByte);
        }
        this.getFlowIdToSocket().put(this.getFlowIdCounter(), socket);
        increaseFlowIdCounter();

        // Start the socket off as initiator
        socket.markAsSender();
        socket.start();

    }

    public void startFlowWithPort(int destination, long flowSizeByte, int sourcePort, int destinationPort) {

        // Create new outgoing socket
        Socket socket;
        if (this.udpException == true) {
            socket = createSocketWithPortAndRealFlowSize(this.getFlowIdCounter(), destination, flowSizeByte, flowSizeByte, sourcePort, destinationPort);
        }
        else {
            socket = createSocketWithPort(this.getFlowIdCounter(), destination, flowSizeByte, sourcePort, destinationPort);
        }
        this.getFlowIdToSocket().put(this.getFlowIdCounter(), socket);
        increaseFlowIdCounter();

        // Start the socket off as initiator
        socket.markAsSender();
        socket.start();

    }

    public void startFlowWithPortAndFlowId(int destination, long flowSizeByte, long flowId, boolean udpExp, int sourcePort, int destinationPort) {

        // Create new outgoing socket
        Socket socket;
        if (udpExp == true) {
            socket = createSocketWithPortAndRealFlowSize(flowId, destination, flowSizeByte, flowSizeByte, sourcePort, destinationPort);
        }
        else {
            socket = createSocketWithPort(flowId, destination, flowSizeByte, sourcePort, destinationPort);
        }
        this.getFlowIdToSocket().put(flowId, socket);


        // Start the socket off as initiator
        socket.markAsSender();
        socket.start();

    }

    protected Socket createSocket(long flowId, int destinationId, long flowSizeByte) {
        return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, 80, 80);
    }

    protected Socket createSocketWithRealFlowSize(long flowId, int destinationId, long flowSizeByte, long realFlowSizeByte) {
        if (flowSizeByte == -1) {
            return new AIFOUDPSocket(this, flowId, destinationId, identifier, flowSizeByte, realFlowSizeByte, 80, 80);
        }
        else {
            return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, realFlowSizeByte, 80, 80);
        }
    }

    protected Socket createSocketWithPort(long flowId, int destinationId, long flowSizeByte, int sourcePort, int destinationPort) {
        return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, sourcePort, destinationPort);
    }

    protected Socket createSocketWithPortAndRealFlowSize(long flowId, int destinationId, long flowSizeByte, long realFlowSizeByte, int sourcePort, int destinationPort) {
        if (flowSizeByte == -1) {
            return new AIFOUDPSocket(this, flowId, destinationId, identifier, flowSizeByte, realFlowSizeByte, sourcePort, destinationPort);
        }
        else {
            return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, realFlowSizeByte, sourcePort, destinationPort);
        }
    }

}