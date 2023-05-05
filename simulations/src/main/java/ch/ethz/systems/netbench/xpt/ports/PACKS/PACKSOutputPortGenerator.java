package ch.ethz.systems.netbench.xpt.ports.PACKS;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class PACKSOutputPortGenerator extends OutputPortGenerator {

    private final long numberQueues;
    private final int sizePerQueue;
    private final String mappingType;
    private final int windowSize;
    private final int sampleCount;
    private final float kValue;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public PACKSOutputPortGenerator(long numberQueues, int sizePerQueue, String mappingType, int windowSize, int sampleCount, float kValue, boolean ecnMarking, long ecnThresholdPackets) {
        this.numberQueues = numberQueues;
        this.sizePerQueue = sizePerQueue;
        this.mappingType = mappingType;

        this.windowSize = windowSize;
        this.sampleCount = sampleCount;
        this.kValue = kValue;

        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;

        SimulationLogger.logInfo("Port", "PACKS(numberQueues=" + numberQueues + ", sizePerQueue=" + sizePerQueue +
                ", mappingType=" + mappingType + ", windowSize=" + windowSize + ", sampleCount=" + sampleCount + ", kValue=" + kValue + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new PACKSOutputPort(ownNetworkDevice, towardsNetworkDevice, link, numberQueues, sizePerQueue, mappingType, windowSize, sampleCount, kValue, ecnMarking, ecnThresholdPackets);
    }
}