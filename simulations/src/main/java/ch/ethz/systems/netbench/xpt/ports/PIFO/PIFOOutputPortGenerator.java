package ch.ethz.systems.netbench.xpt.ports.PIFO;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Link;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.OutputPort;
import ch.ethz.systems.netbench.core.run.infrastructure.OutputPortGenerator;

public class PIFOOutputPortGenerator extends OutputPortGenerator {

    private final long sizePackets;
    private final boolean ecnMarking;
    private final long ecnThresholdPackets;

    public PIFOOutputPortGenerator(long sizePackets, boolean ecnMarking, long ecnThresholdPackets) {
        this.sizePackets = sizePackets;
        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;
        SimulationLogger.logInfo("Port", "PIFO(sizePackets=" + sizePackets + ", ecnMarking=" + ecnMarking + ", ecnThresholdPackets=" + ecnThresholdPackets +  ")");
    }

    @Override
    public OutputPort generate(NetworkDevice ownNetworkDevice, NetworkDevice towardsNetworkDevice, Link link) {
        return new PIFOOutputPort(ownNetworkDevice, towardsNetworkDevice, link, sizePackets, ecnMarking, ecnThresholdPackets);
    }

}
