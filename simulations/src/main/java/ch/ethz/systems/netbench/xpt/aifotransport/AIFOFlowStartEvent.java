package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.core.run.traffic.FlowStartEvent;

public class AIFOFlowStartEvent extends FlowStartEvent {

    private long flowIdCounter;
    private boolean udpExp;
    private int sourcePort;
    private int destinationPort;

    public AIFOFlowStartEvent(long timeFromNowNs, TransportLayer transportLayer, int targetId, long flowSizeByte) {
        super(timeFromNowNs, transportLayer, targetId, flowSizeByte);
        this.flowIdCounter = -1;
        this.udpExp = false;
        this.sourcePort = 80;
        this.destinationPort = 80;
    }

    public AIFOFlowStartEvent(long timeFromNowNs, TransportLayer transportLayer, int targetId, long flowSizeByte, long flowId) {
        super(timeFromNowNs, transportLayer, targetId, flowSizeByte);
        this.flowIdCounter = flowId;
        this.udpExp = false;
    }

    public AIFOFlowStartEvent(long timeFromNowNs, TransportLayer transportLayer, int targetId, long flowSizeByte, long flowId, boolean udpExp) {
        super(timeFromNowNs, transportLayer, targetId, flowSizeByte);
        this.flowIdCounter = flowId;
        this.udpExp = udpExp;
        this.sourcePort = 80;
        this.destinationPort = 80;
    }

    public AIFOFlowStartEvent(long timeFromNowNs, TransportLayer transportLayer, int targetId, long flowSizeByte, long flowId, int sourcePort, int destinationPort) {
        super(timeFromNowNs, transportLayer, targetId, flowSizeByte);
        this.flowIdCounter = flowId;
        this.udpExp = false;
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
    }

    @Override
    public void trigger() {
        if (this.flowIdCounter == -1) {
            ((AIFOTransportLayer)this.getTransportLayer()).startFlowWithPort(this.getTargetId(), this.getFlowSizeByte(), this.sourcePort, this.destinationPort);
        }
        else {
            ((AIFOTransportLayer)this.getTransportLayer()).startFlowWithPortAndFlowId(this.getTargetId(), this.getFlowSizeByte(), flowIdCounter, this.udpExp, this.sourcePort, this.destinationPort);
        }
    }

}
