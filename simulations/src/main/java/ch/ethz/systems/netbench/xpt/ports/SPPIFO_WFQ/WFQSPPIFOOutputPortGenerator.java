package ch.ethz.systems.netbench.xpt.ports.SPPIFO_WFQ;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class WFQSPPIFOOutputPortGenerator extends OutputPortGenerator {

    private final long numberQueues;
    private final long sizePerQueuePackets;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public WFQSPPIFOOutputPortGenerator(long numberQueues, long sizePerQueuePackets, boolean ecnMarking, long ecnThresholdPackets) {
        this.numberQueues = numberQueues;
        this.sizePerQueuePackets = sizePerQueuePackets;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "WFQSPPIFO(numberQueues=" + numberQueues + ", sizePerQueuePackets=" + sizePerQueuePackets + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new WFQSPPIFOOutputPort(ownNetworkDevice, towardsNetworkDevice, link, numberQueues, sizePerQueuePackets, ecnMarking, ecnThresholdPackets);
    }

}
