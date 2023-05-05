package ch.ethz.systems.netbench.xpt.ports.AIFO;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class AIFOOutputPortGenerator extends OutputPortGenerator {

    private final int maxQueueSize;
    private final int windowSize;
    private final int sampleCount;
    private final float kValue;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public AIFOOutputPortGenerator(int maxQueueSize, int windowSize, int sampleCount, float kValue, boolean ecnMarking, long ecnThresholdPackets) {
        this.maxQueueSize = maxQueueSize;
        this.windowSize = windowSize;
        this.sampleCount = sampleCount;
        this.kValue = kValue;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "AIFO(maxQueueSize=" + maxQueueSize + ", windowSize=" + windowSize +
                ", sampleCount=" + sampleCount + ", kValue=" + kValue + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new AIFOOutputPort(ownNetworkDevice, towardsNetworkDevice, link, maxQueueSize, windowSize, sampleCount, kValue, ecnMarking, ecnThresholdPackets);
    }
}
