package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.log.FlowLogger;
import ch.ethz.systems.netbench.core.log.SimulationLogger;

public class AIFOFlowLogger extends FlowLogger {

    private int sourcePort;
    private int destinationPort;


    public AIFOFlowLogger(long flowId, int sourceId, int targetId, long flowSizeByte) {
        super(flowId, sourceId, targetId, flowSizeByte);
        this.setStatisticSampleIntervalBytes(5000);
    }

    public AIFOFlowLogger(long flowId, int sourceId, int targetId, long flowSizeByte, boolean udpException, long realFlowSizeByte) {
        super(flowId, sourceId, targetId, flowSizeByte);

        // Register logger only for sender
        // Or if we are udp, only for receiver
        if ((udpException) && (this.getFlowSizeByte() == -1)) {
            SimulationLogger.registerFlowLogger(this);
        }

        this.setFlowSizeByte(realFlowSizeByte);
    }

    public AIFOFlowLogger(long flowId, int sourceId, int targetId, long flowSizeByte, int sourcePort, int destinationPort) {
        super(flowId, sourceId, targetId, flowSizeByte);
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
    }

    public AIFOFlowLogger(long flowId, int sourceId, int targetId, long flowSizeByte, boolean udpException, long realFlowSizeByte, int sourcePort, int destinationPort) {
        super(flowId, sourceId, targetId, flowSizeByte);
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;

        // Register logger only for sender
        // Or if we are udp, only for receiver
        if ((udpException) && (this.getFlowSizeByte() == -1)) {
            SimulationLogger.registerFlowLogger(this);
        }
        this.setFlowSizeByte(realFlowSizeByte);
    }

    @Override
    public boolean isCompleted() {
        return this.getTotalBytesReceived() >= this.getFlowSizeByte();
    }

    public int getSourcePort() { return sourcePort; }
    public int getDestinationPort() { return destinationPort; }
}
