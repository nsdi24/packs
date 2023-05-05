package ch.ethz.systems.netbench.xpt.ports.FIFO;

import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;

import java.util.concurrent.ArrayBlockingQueue;

// We just create the class to be able to measure inversions at dequeue for the FIFO queue
public class FIFOQueue<E> extends ArrayBlockingQueue<E> {

    private final int ownId;                            // Own network device identifier

    public FIFOQueue(int capacity, int ownId) {
        super(capacity);
        this.ownId = ownId;
    }

    @Override
    public E poll() {
        E element = super.poll();
        Packet p = (Packet) element;

        if (p != null){
            int rank = 0;
            if (p.isTCP()){
                rank = (int)((FullExtTcpPacket)p).getPriority();
            } else {
                rank = (int)((FullExtUdpPacket)p).getPriority();
            }

            // Check whether there is an inversion: a packet with smaller rank in queue than the one polled
            if (SimulationLogger.hasInversionsTrackingEnabled()) {
                int count_inversions = 0;
                Object[] contentFIFO = this.toArray();
                for (int j = 0; j < contentFIFO.length; j++) {
                    Packet cq = (Packet) contentFIFO[j];
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
                if (count_inversions != 0) {
                    SimulationLogger.logInversionsPerRank(this.ownId, rank, count_inversions);
                }
            }
        }
        return element;
    }
}
