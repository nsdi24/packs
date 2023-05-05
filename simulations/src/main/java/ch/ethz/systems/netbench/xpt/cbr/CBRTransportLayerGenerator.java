package ch.ethz.systems.netbench.xpt.cbr;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.core.run.infrastructure.TransportLayerGenerator;

public class CBRTransportLayerGenerator extends TransportLayerGenerator {

    private boolean randomEnabled;
    private boolean ranksEnabled;
    private String rankDistribution;
    private long rankBound;

    public CBRTransportLayerGenerator(boolean randomEnabled, boolean ranksEnabled, String rankDistribution, long rankBound) {
        SimulationLogger.logInfo("Transport layer", "CBR");
        this.randomEnabled = randomEnabled;
        this.ranksEnabled = ranksEnabled;
        this.rankDistribution = rankDistribution;
        this.rankBound = rankBound;
    }

    @Override
    public TransportLayer generate(int identifier) {
        return new CBRTransportLayer(identifier, this.randomEnabled, this.ranksEnabled, this.rankDistribution, this.rankBound);
    }

}
