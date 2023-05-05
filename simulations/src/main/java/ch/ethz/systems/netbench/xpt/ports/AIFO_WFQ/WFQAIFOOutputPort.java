package ch.ethz.systems.netbench.xpt.ports.AIFO_WFQ;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WFQAIFOOutputPort extends OutputPort {

    private boolean ecnMarking;
    private long ecnThresholdPackets;

    private int windowSize; // Size of sliding window to track ranks of recent packets
    private float k; // Headroom parameter to tolerate small bursts
    private int qlen;  // C of paper i.e., max. amount of packets we can put in FIFO queue

    /*
    To efficiently use precious switch resources, we use a sampling method to virtually scale up the sliding window
    size by adding a sampler aside with the index tagger. For example, instead of using a window with the size of 1000,
    we can use a smaller window with the size of 20, and set the sampling rate as 0.02.
    */
    private int sampleCount; // To control the sample rate

    private Queue qWindow;
    private int count;

    // STFQ Attributes
    private final Map last_finishTime;

    WFQAIFOOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, int maxQueueSize, int windowSize, int sampleCount, float kValue, boolean ecnMarking, long ecnThresholdPackets) {
        super(ownNetworkDevice, targetNetworkDevice, link, new WFQAIFOOutputQueue<Packet>(maxQueueSize));

        this.ecnMarking = ecnMarking;
        this.ecnThresholdPackets = ecnThresholdPackets;

        this.windowSize = windowSize;
        this.k = kValue; // k can be changed e.g., among [0.1, 0.5]
        this.qlen = maxQueueSize; // qlen is the "C" in the algorithm (maximum number of packets we can put into the queue)
        this.sampleCount = sampleCount; // Control the sample rate

        this.qWindow = new LinkedList();
        this.count = 0;

        // STFQ Attributes
        this.last_finishTime = new HashMap();
    }

    /*Rank computation following STFQ as proposed in the PIFO paper*/
    public int computeRank(Packet p){
        int startTime = ((WFQAIFOOutputQueue<Packet>)this.getQueue()).getRound();
        if(last_finishTime.containsKey(p.getFlowId())){
            if((int) last_finishTime.get(p.getFlowId()) > ((WFQAIFOOutputQueue<Packet>)this.getQueue()).getRound()){
                startTime = (int)last_finishTime.get(p.getFlowId());
            }
        }
        int flowWeight = 8;
        int finishingTime_update = startTime + ((int)p.getSizeBit()/flowWeight);
        last_finishTime.put(p.getFlowId(), finishingTime_update);
        return startTime;
    }

    /**
     * Enqueue the given packet.
     * To control droppings
     * There is no guarantee that the packet is actually sent,
     * as the queue buffer's limit might be reached.
     * @param packet    Packet instance
     */
    @Override
    public void enqueue(Packet packet) {

        // ECN: Mark congestion flag if size of the queue is too big
        if (this.ecnMarking) {
            if (this.getQueue().size() >= this.ecnThresholdPackets) {
                ((IpHeader) packet).markCongestionEncountered();
            }
        }

        // Compute rank and add
        int rankComputed = this.computeRank(packet);
        if (packet.isTCP()){
            ((FullExtTcpPacket)packet).setPriority(rankComputed);
        } else {
            ((FullExtUdpPacket)packet).setPriority(rankComputed);
        }
        int rank = rankComputed;

        // Update sliding window
        if (this.count == 0) {
            if (qWindow.size() < this.windowSize) {
                qWindow.add(packet);
            }
            else {
                qWindow.poll();
                qWindow.add(packet);
            }
        }
        this.count = this.count + 1;
        if (this.count == this.sampleCount) {
            this.count = 0;
        }

        // Enqueue / send packet iff quantile <= 1/1-k * C-c/C
        boolean admit_flag = compareQuantile(rank, 1.0/(1-this.k) * (this.qlen - this.getQueue().size()) / this.qlen);
        if (admit_flag) {

            // If it is not sending, then the queue is empty at the moment,
            // so this packet can be immediately send
            if (!getIsSending()) {

                // Link is now being utilized
                getLogger().logLinkUtilized(true);

                // Add event when sending is finished
                Simulator.registerEvent(new PacketDispatchedEvent(
                        (long)((double)packet.getSizeBit() / getLink().getBandwidthBitPerNs()),
                        packet,
                        this
                ));

                // It is now sending again
                setIsSending();

            } else { // If it is still sending, the packet is added to the queue, making it non-empty

                    // Try to enqueue to the AIFO queue
                    WFQAIFOOutputQueue queue = (WFQAIFOOutputQueue) getQueue();
                    boolean result = queue.offer(packet);

                    if (result) {
                        // Update buffer size with enqueued packet
                        increaseBufferOccupiedBits(packet.getSizeBit());
                        getLogger().logQueueState(queue.size(), getBufferOccupiedBits());
                    } else {
                        last_finishTime.put(packet.getFlowId(), (int)last_finishTime.get(packet.getFlowId()) - ((int)packet.getSizeBit()/8));
                        SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
                        IpHeader ipHeader = (IpHeader) packet;
                        if (ipHeader.getSourceId() == this.getOwnId()) {
                            SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
                        }
                    }
            }
        } else {
            last_finishTime.put(packet.getFlowId(), (int)last_finishTime.get(packet.getFlowId()) - ((int)packet.getSizeBit()/8));
            SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
            IpHeader ipHeader = (IpHeader) packet;
            if (ipHeader.getSourceId() == this.getOwnId()) {
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
            }
        }
    }

    public boolean compareQuantile(int priority, double quantile) {
        if (qWindow.size() == 0)
            return true;
        Object[] contentPIFO = qWindow.toArray();
        int count = 0;
        for (int i =0; i<contentPIFO.length; i++) {

            // Extract rank from header
            Packet packet = (Packet) contentPIFO[(int) i];
            int rank = 0;
            if (packet.isTCP()){
                rank = (int)((FullExtTcpPacket)packet).getPriority();
            } else {
                rank = (int)((FullExtUdpPacket)packet).getPriority();
            }

            if (priority > rank)
                count += 1;
        }
        if (count * 1.0  < quantile * qWindow.size())
            return true;
        return false;
    }
}
