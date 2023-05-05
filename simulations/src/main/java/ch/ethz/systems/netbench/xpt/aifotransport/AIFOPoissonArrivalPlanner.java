package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.run.traffic.FlowStartEvent;
import ch.ethz.systems.netbench.ext.poissontraffic.PoissonArrivalPlanner;
import ch.ethz.systems.netbench.ext.poissontraffic.flowsize.FlowSizeDistribution;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.core.SelfDefinedFlows;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.Random;

public class AIFOPoissonArrivalPlanner extends PoissonArrivalPlanner {

    private static long flowIdCounter = 0;

    public AIFOPoissonArrivalPlanner(Map<Integer, TransportLayer> idToTransportLayerMap, double lambdaFlowStartsPerSecond, FlowSizeDistribution flowSizeDistribution, PairDistribution allToAll) {
        super(idToTransportLayerMap, lambdaFlowStartsPerSecond, flowSizeDistribution, allToAll);
    }


    /**
     * Register the flow from [srcId] to [dstId].
     *
     * @param time          Time at which it start in nanoseconds
     * @param srcId         Source network device identifier
     * @param dstId         Destination network device identifier
     * @param flowSizeByte  Flow size in bytes
     */
    @Override
    protected void registerFlow(long time, int srcId, int dstId, long flowSizeByte) {

        // Some checking
        if (srcId == dstId) {
            throw new RuntimeException("Invalid traffic pair; source (" + srcId + ") and destination (" + dstId + ") are the same.");
        } else if (idToTransportLayerMap.get(srcId) == null) {
            throw new RuntimeException("Source network device " + srcId + " does not have a transport layer.");
        } else if (idToTransportLayerMap.get(dstId) == null) {
            throw new RuntimeException("Destination network device " + dstId + ") does not have a transport layer.");
        } else if (time < 0) {
            throw new RuntimeException("Cannot register a flow with a negative timestamp of " + time);
        } else if (flowSizeByte < 0) {
            throw new RuntimeException("Cannot register a flow with a negative flow size (in bytes) of " + flowSizeByte);
        }

        // Create event
        FlowStartEvent event = new AIFOFlowStartEvent(time, idToTransportLayerMap.get(srcId), dstId, flowSizeByte, flowIdCounter);
        flowIdCounter++;

        // Register event
        Simulator.registerEvent(event);

    }

    protected void registerFlowWithPort(long time, int srcId, int dstId, long flowSizeByte, int sourcePort, int destinationPort) {

        // Some checking
        if (srcId == dstId) {
            throw new RuntimeException("Invalid traffic pair; source (" + srcId + ") and destination (" + dstId + ") are the same.");
        } else if (idToTransportLayerMap.get(srcId) == null) {
            throw new RuntimeException("Source network device " + srcId + " does not have a transport layer.");
        } else if (idToTransportLayerMap.get(dstId) == null) {
            throw new RuntimeException("Destination network device " + dstId + ") does not have a transport layer.");
        } else if (time < 0) {
            throw new RuntimeException("Cannot register a flow with a negative timestamp of " + time);
        } else if (flowSizeByte < 0) {
            throw new RuntimeException("Cannot register a flow with a negative flow size (in bytes) of " + flowSizeByte);
        }

        // Create event
        FlowStartEvent event = new AIFOFlowStartEvent(time, idToTransportLayerMap.get(srcId), dstId, flowSizeByte, flowIdCounter, sourcePort, destinationPort);
        flowIdCounter++;

        // Register event
        Simulator.registerEvent(event);
    }

    public static void staticReset() {
        flowIdCounter = 0;
    }

    @Override
    public void createPlan(long durationNs) {
        System.out.print("Creating arrival plan...");

        // Statistics tracking
        long time = 0;
        int x = 0;
        long sum = 0;
        int mod_nx;

        // Generate flow start events until the duration
        // of the experiment has lapsed
        long nextProgressLog = durationNs / 10;
        int count = 0;
        long interArrivalTime = (long) (-Math.log(this.getOwnIndependentRng().nextDouble()) / (this.getLambdaFlowStartsPerSecond() / 1e9));
        long fs1 = 1000000000L;
        long nextUDPStartTime = 50000000;
        int very_big_flow_size = 2000000000;

        //this.increaseFlowIdCounter();
        time = 0;

        //This block is for self-defined flow experiments
        if (SelfDefinedFlows.isSDF == true) {
            registerFlowWithPort(time, 0, 10, 100000000,80, 80);
            registerFlowWithPort(time, 1, 10, 50000000,80, 80);
            registerFlowWithPort(time, 2, 10, 10000000,80, 80);
            x = 10; //redundant, to avoid divided by 0 error
        }

        // Make the traffic 10 times larger
        //changed it to 10*traffic for 10/40
        //lambdaFlowStartsPerSecond = lambdaFlowStartsPerSecond * 10;
        // ** DCN workload ---- web search, data mining
        else {
            while (time <= durationNs) {

                // Poisson arrival
                //
                // F(x) = 1 - e^(-lambda * x)
                // <=>
                // ln( 1 - F(x) ) = -lambda * x
                // <=>
                // x = -ln( 1 - F(x) ) / lambda
                // <=>
                // x = -ln( Uniform(x) ) / lambda
                //
                interArrivalTime = (long) (-Math.log(this.getOwnIndependentRng().nextDouble()) / (this.getLambdaFlowStartsPerSecond() / 1e9));

                // Add to sum for later statistics
                sum += interArrivalTime;

                // Register flow
                Pair<Integer, Integer> pair;
                pair = this.choosePair();

                Random independentRng = new Random();
                registerFlowWithPort(time, pair.getLeft(), pair.getRight(), this.getFlowSizeDistribution().generateFlowSizeByte(),80, 80);

                // Advance time to next arrival
                time += interArrivalTime;
                x++;

                if (time > nextProgressLog) {
                    System.out.print(" " + (100 * time / durationNs) + "%...");
                    nextProgressLog += durationNs / 10;
                }

                count ++;
            }
        }

        System.out.println(" done.");

        // Log plan created
        System.out.println("Poisson Arrival plan created.");
        System.out.println("Number of flows created: " + x + ".");
        System.out.println("Mean inter-arrival time: " + (sum / x) + " (expectation: "
                + (1 / (this.getLambdaFlowStartsPerSecond() / 1e9)) + ")");
        SimulationLogger.logInfo("Flow planner number flows", String.valueOf(x));
        SimulationLogger.logInfo("Flow planner mean inter-arrival time", String.valueOf((sum / x)));
        SimulationLogger.logInfo("Flow planner expected inter-arrival time", String.valueOf((1 / (this.getLambdaFlowStartsPerSecond() / 1e9))));
        SimulationLogger.logInfo("Flow planner poisson rate lambda (flow starts/s)", String.valueOf(this.getLambdaFlowStartsPerSecond()));

    }
}
