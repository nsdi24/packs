package ch.ethz.systems.netbench.xpt.ports.FIFO;


import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class FIFOOutputPortGenerator extends OutputPortGenerator {

    private final int maxQueueSize;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public FIFOOutputPortGenerator(int maxQueueSize, boolean ecnMarking, long ecnThresholdPackets) {
        this.maxQueueSize = maxQueueSize;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "FIFO(maxQueueSize=" + maxQueueSize + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new FIFOOutputPort(ownNetworkDevice, towardsNetworkDevice, link, maxQueueSize, ecnMarking, ecnThresholdPackets);
    }

}
