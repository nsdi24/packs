package ch.ethz.systems.netbench.xpt.ports.AFQ;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class AFQOutputPortGenerator extends OutputPortGenerator {

    private final long numQueues;
    private final long perQueueCapacity;
    private final long bytesPerRound;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public AFQOutputPortGenerator(long numQueues, long perQueueCapacity, long bytesPerRound, boolean ecnMarking, long ecnThresholdPackets) {
        this.numQueues = numQueues;
        this.perQueueCapacity = perQueueCapacity;
        this.bytesPerRound = bytesPerRound;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "AFQ(numQueues=" + numQueues +  ", perQueueCapacity=" + perQueueCapacity + ", bytesPerRound=" + bytesPerRound + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new AFQOutputPort(ownNetworkDevice, towardsNetworkDevice, link, numQueues, perQueueCapacity, bytesPerRound, ecnMarking, ecnThresholdPackets);
    }

}
