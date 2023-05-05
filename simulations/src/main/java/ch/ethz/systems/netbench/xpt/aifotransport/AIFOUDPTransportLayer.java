package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.network.Socket;

public class AIFOUDPTransportLayer extends AIFOTransportLayer {

    AIFOUDPTransportLayer(int identifier) {
        super(identifier);
    }

    @Override
    protected Socket createSocket(long flowId, int destinationId, long flowSizeByte) {
        return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, 80, 80);
    }

    @Override
    protected Socket createSocketWithRealFlowSize(long flowId, int destinationId, long flowSizeByte, long realFlowSizeByte) {
        if (flowSizeByte == -1) {
            return new AIFOUDPSocket(this, flowId, destinationId, identifier, flowSizeByte, realFlowSizeByte, 80, 80);
        }
        else {
            return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, realFlowSizeByte, 80, 80);
        }
    }

    @Override
    protected Socket createSocketWithPort(long flowId, int destinationId, long flowSizeByte, int sourcePort, int destinationPort) {
        return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, sourcePort, destinationPort);
    }

    @Override
    protected Socket createSocketWithPortAndRealFlowSize(long flowId, int destinationId, long flowSizeByte, long realFlowSizeByte, int sourcePort, int destinationPort) {
        if (flowSizeByte == -1) {
            return new AIFOUDPSocket(this, flowId, destinationId, identifier, flowSizeByte, realFlowSizeByte, sourcePort, destinationPort);
        }
        else {
            return new AIFOUDPSocket(this, flowId, identifier, destinationId, flowSizeByte, realFlowSizeByte, sourcePort, destinationPort);
        }
    }

}
