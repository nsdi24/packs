package ch.ethz.systems.netbench.xpt.ports.AIFO_WFQ;

import ch.ethz.systems.netbench.core.network.Packet;
import ch.ethz.systems.netbench.xpt.tcpbase.FullExtTcpPacket;
import ch.ethz.systems.netbench.xpt.udp.FullExtUdpPacket;
import java.util.concurrent.ArrayBlockingQueue;

public class WFQAIFOOutputQueue<Object> extends ArrayBlockingQueue<Object> {
    private int round;

    public WFQAIFOOutputQueue(int capacity){
        super(capacity);
        round = 0;
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

    @Override
    public Object poll() {
        Object packet = super.poll();
        Packet p = (Packet) packet;
        this.updateRound(p);
        return packet;
    }

    public int getRound() {
        return this.round;
    }

}
