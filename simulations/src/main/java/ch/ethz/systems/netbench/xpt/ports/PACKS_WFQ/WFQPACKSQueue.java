package ch.ethz.systems.netbench.xpt.ports.PACKS_WFQ;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.NetworkDevice;
import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class WFQPACKSQueue implements Queue {

    private int round; // WFQ: Round updated when a packet is polled

    private final ArrayList<ArrayBlockingQueue> queueList; // List of queues
    private int sizePerQueue;                  // The buffer size of all the queues always needs to be smaller than this value
    private int ownId;                            // Network Device ID

    private int windowSize; // Size of sliding window to track ranks of recent packets
    private float k; // Headroom parameter to tolerate small bursts
    private double qlen;  // C of paper i.e., max. amount of packets we can put in FIFO queue
    private int sampleCount; // To control the sample rate
    private Queue qWindow;
    private int count;

    public WFQPACKSQueue(long numQueues, int sizePerQueue, NetworkDevice ownNetworkDevice, String mappingType, int windowSize, int sampleCount, float kValue) {

        this.sizePerQueue = sizePerQueue;
        this.ownId = ownNetworkDevice.getIdentifier();

        // The actual queues where packets are stored
        this.queueList = new ArrayList((int) numQueues);

        // Initialization of those queues
        ArrayBlockingQueue fifo;
        for (int i = 0; i < (int) numQueues; i++) {
            fifo = new ArrayBlockingQueue<Packet>(this.sizePerQueue);
            queueList.add(fifo);
        }

        this.windowSize = windowSize;
        this.k = kValue; // k can be changed e.g., among [0.1, 0.5]
        this.qlen = numQueues*sizePerQueue; // qlen is the "C" in the algorithm (maximum number of packets we can put into the queue)
        this.sampleCount = sampleCount; // Control the sample rate

        this.qWindow = new LinkedList();
        this.count = 0;

        // WFQ
        this.round = 0;

    }

    // true iff quantile <= 1/1-k * C-c/C
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


    // Packet dropped and null returned if selected queue exceeds its size
    @Override
    public boolean offer(Object o) {

        Packet packet = (Packet) o;
        int rank;
        if (packet.isTCP()) {
            rank = (int) ((FullExtTcpPacket) packet).getPriority();
        } else {
            rank = (int) ((FullExtUdpPacket) packet).getPriority();
        }

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

        // Mapping based on quantiles
        double division = 1 / (double)queueList.size();
        boolean admit_flag;
        for (int q=0; q<queueList.size(); q++){
            //System.out.println("Top " + (q+1) + "-est priority queue: Admit if rank <= " + (q+1) * division + "-th quantile");

            /* For 8 queues:
            Highest priority queue: Admit if rank <= 0.125-th quantile
            Top 2-est priority queue: Admit if rank <= 0.25-th quantile
            Top 3-est priority queue: Admit if rank <= 0.375-th quantile
            Top 4-est priority queue: Admit if rank <= 0.5-th quantile
            Top 5-est priority queue: Admit if rank <= 0.625-th quantile
            Top 6-est priority queue: Admit if rank <= 0.75-th quantile
            Top 7-est priority queue: Admit if rank <= 0.875-th quantile
            Lowest priority queue: Admit if rank <= 1.0-th quantile */
            admit_flag = compareQuantile(rank, 1.0/(1-this.k) * ((q+1) * division) * (this.qlen - this.size()) / this.qlen);
            if (admit_flag) {
                //System.out.println("Packet with rank " + rank + " enqueued in queue " + q+1 + " since " + rank + " <= " + (q+1) * division + "-th quantile");
                boolean result = queueList.get(q).offer(packet); // We enqueue if there is enough size
                if (result){
                    return true;
                }
            }
        }
        return false;
    }

    /*Round is the virtual start time of the last dequeued packet across all flows*/
    public void updateRound(Packet p){
        int rank;
        if (p.isTCP()) {
            rank = (int) ((FullExtTcpPacket) p).getPriority();
        } else {
            rank = (int) ((FullExtUdpPacket) p).getPriority();
        }
        this.round = rank;
    }

    public int getRound() {
        return this.round;
    }

    @Override
    public Object poll() {
        Packet p;
        for (int q=0; q<queueList.size(); q++){
            p = (Packet) queueList.get(q).poll();
            if (p != null){

                // WFQ
                this.updateRound(p);

                int rank = 0;
                if (p.isTCP()){
                    rank = (int)((FullExtTcpPacket)p).getPriority();
                } else {
                    rank = (int)((FullExtUdpPacket)p).getPriority();
                }

                // Log rank of packet enqueued and queue selected if enabled
                if(SimulationLogger.hasRankMappingEnabled()){
                    SimulationLogger.logRankMapping(this.ownId, rank, q);
                }

                // Check whether there is an inversion: a packet with smaller rank in queue than the one polled
                if (SimulationLogger.hasInversionsTrackingEnabled()) {
                    int count_inversions = 0;
                    for (int i = 0; i <= queueList.size() - 1; i++) {
                        Object[] currentQueue = queueList.get(i).toArray();
                        for (int j = 0; j < currentQueue.length; j++) {
                            Packet cq = (Packet) currentQueue[j];
                            int r = 0;
                            if (cq.isTCP()){
                                r = (int) ((FullExtTcpPacket) cq).getPriority();
                            } else {
                                r = (int) ((FullExtUdpPacket) cq).getPriority();
                            }
                            if (r < rank) {
                                count_inversions++;
                            }
                        }
                    }
                    if (count_inversions != 0) {
                        SimulationLogger.logInversionsPerRank(this.ownId, rank, count_inversions);
                    }
                }
                return p;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int q=0; q<queueList.size(); q++){
            size += queueList.get(q).size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (int q=0; q<queueList.size(); q++){
            if(!queueList.get(q).isEmpty()){
                empty = false;
            }
        }
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() { }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
