package ch.ethz.systems.netbench.xpt.cbr;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.core.network.TransportLayer;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;
import ch.ethz.systems.netbench.xpt.udp.UdpPacket;
import ch.ethz.systems.netbench.xpt.udp.UdpSocket;
import ch.ethz.systems.netbench.xpt.tcpextended.lstftcp.RandomNumberGenerator;

import java.util.Random;

public class CBRSocket extends UdpSocket {

    // Specific of CBR Traffic generator
    protected boolean running;
    protected long packetSizeBits;
    protected float rateBitPerNs;
    protected double timeStart;
    protected double timeEnd;
    protected boolean randomEnabled;
    protected boolean ranksEnabled;
    protected String rankDistribution;
    protected long rankBound;

    /*
     * Constant bit rate traffic source.   Parameterized by interval, (optional)
     * random noise in the interval, and packet size.
     */

    public CBRSocket(TransportLayer transportLayer, long flowId, int sourceId, int destinationId,
                     long packetSize, float rate, double timeStart, double timeEnd, boolean randomEnabled, boolean ranksEnabled, String rankDistribution, long rankBound) {

        super(transportLayer, flowId, sourceId, destinationId, -1);

        this.running = false;
        this.packetSizeBits = packetSize;
        this.rateBitPerNs = rate;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.randomEnabled = randomEnabled;
        this.ranksEnabled = ranksEnabled;
        this.rankDistribution = rankDistribution;
        this.rankBound = rankBound;
    }

    /**
     * Makes the socket a sender and initiates the communication.
     */
    @Override
    public void start() {
        this.timeout();
        System.out.println(Simulator.getCurrentTime()/1000000000 + "s: CBRSocket started");
    }

    /**
     * Used by the receiver to process packets. We don't do much
     */
    @Override
    public void handle(Packet genericPacket) {
        // We don't do any processing for packets received
        SimulationLogger.increaseStatisticCounter("UDP_PACKETS_RECEIVED"); // This just does + 1 (since length not added)
    }

    void timeout() {
        long now = Simulator.getCurrentTime();
        if (now >= timeStart && now < timeEnd) {
            this.running = true;
            // We send a packet
            UdpPacket packet = createPacket(this.packetSizeBits/8);
            transportLayer.send(packet);
            SimulationLogger.increaseStatisticCounter("UDP_PACKET_SENT");

            // We revisit the task after interval time
            double waitFor = ((double)packet.getSizeBit()/rateBitPerNs); // nanoseconds
            if (this.randomEnabled){
                Random independentRng = new Random();
                double outcome = independentRng.nextDouble() - 0.5; //Distribuited uniformly from -0.5 to 0.5
                waitFor = waitFor + (((double)packet.getSizeBit()/rateBitPerNs)* outcome); // nanoseconds. We use getSizeBit to consider the whole packet size, not just the data
            }
            CBRSendEvent sendEvent = new CBRSendEvent((long)waitFor, this);
            Simulator.registerEvent(sendEvent);
        } else {
            this.running = false;
        }
    }


    /**
     * Create a UDP packet.
     *
     * @param dataSizeByte      Data size carried in bytes
     *
     * @return  UDP packet instance
     */
    @Override
    protected UdpPacket createPacket(long dataSizeByte) {
        long priority = 0;

        if (rankDistribution.equals("uniform")){
            Random independentRng = new Random();
            double outcome = independentRng.nextDouble()*this.rankBound; //Ranks distribuited uniformly from 1 to 100
            priority = (long)outcome;

        } else if (rankDistribution.equals("exponential")){
            RandomNumberGenerator testStat = RandomNumberGenerator.Exponential;
            double lambda = 1.0 / 25.0;
            int result = (int) testStat.getRandom(lambda);
            while (result > 99) {
                result = (int) testStat.getRandom(lambda);
            }
            priority = (long)result;

        } else if (rankDistribution.equals("inverse_exponential")){
            RandomNumberGenerator testStat = RandomNumberGenerator.Exponential;
            double lambda = 1.0 / 25.0;
            int result = (int) testStat.getRandom(lambda);
            while (result > 99) {
                result = (int) testStat.getRandom(lambda);
            }
            result = 100 - result;
            priority = (long) (Math.abs(result));

        } else if (rankDistribution.equals("poisson")){
            RandomNumberGenerator testStat = RandomNumberGenerator.Poisson;
            double lambda = 30;  // Changed for PACKS, was 50 for SP-PIFO
            int result = (int) testStat.getRandom(lambda);
            priority = (long) Math.abs(result);

        } else if (rankDistribution.equals(("minmax"))){
            RandomNumberGenerator testStat = RandomNumberGenerator.Poisson;
            double lambda = 50;
            int result = (int) testStat.getRandom(lambda) - 10;
            result = Math.abs(result % 50);
            priority = (long) Math.abs(result);

        } else if (rankDistribution.equals("convex")){
            RandomNumberGenerator testStat = RandomNumberGenerator.Poisson;
            double lambda = 100;
            int result = (int) testStat.getRandom(lambda);
            result = Math.abs(result % 100);
            priority = (long) Math.abs(result);

        }

        // Log packet for debugging
        if (SimulationLogger.hasPacketsTrackingEnabled()) {
            SimulationLogger.logPacket("Time: " + Simulator.getCurrentTime() + " => UDP Packet generated, Priority: "+ priority);
        }


        return new FullExtUdpPacket(
                flowId, dataSizeByte, sourceId, destinationId,
                100, 80, 80, // TTL, source port, destination port
                0,0, priority // Length, checksum
        );
    }

}






