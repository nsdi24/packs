package ch.ethz.systems.netbench.xpt.ports.SPPIFO;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class SPPIFOOutputPortGenerator extends OutputPortGenerator {

    private final long numberQueues;
    private final long sizePerQueuePackets;
    private final String stepSize;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public SPPIFOOutputPortGenerator(long numberQueues, long sizePerQueuePackets, String stepSize, boolean ecnMarking, long ecnThresholdPackets) {
        this.numberQueues = numberQueues;
        this.sizePerQueuePackets = sizePerQueuePackets;
        this.stepSize = stepSize;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "SPPIFO(numberQueues=" + numberQueues + ", sizePerQueuePackets=" + sizePerQueuePackets +
                ", stepSize=" + stepSize + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new SPPIFOOutputPort(ownNetworkDevice, towardsNetworkDevice, link, numberQueues, sizePerQueuePackets, stepSize, ecnMarking, ecnThresholdPackets);
    }

}
