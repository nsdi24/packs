package ch.ethz.systems.netbench.xpt.udp;

public class FullExtUdpPacket extends UdpPacket implements UdpPriorityHeader, Comparable {

    private long priority;

    public FullExtUdpPacket(long flowId, long dataSizeByte, int sourceId, int destinationId, int TTL, int sourcePort, int destinationPort, int length, long checksum, long priority) {
        super(flowId, dataSizeByte, sourceId, destinationId, TTL, sourcePort, destinationPort, length, checksum);
        this.priority = priority;
    }

    @Override
    public long getPriority() {
        return priority;
    }

    @Override
    public void increasePriority() {
        priority++;
    }

    @Override
    public void setPriority(long val) {
        priority = val;
    }

    @Override
    public int compareTo(Object o) {
        // "this" is the packet being inserted
        // "other" is the packet we're comparing to (in the queue)
        FullExtUdpPacket other = (FullExtUdpPacket) o;

        // Priority = rank
        int i = Long.compare((int)this.getPriority(), (int)other.getPriority());
        // If the ranks are not equal, return comparator int
        if (i != 0) return i;

        i = Long.compare((int)this.getEnqueueTime(), (int)other.getEnqueueTime());
        //System.out.println("Comparison: " + i + " other " + (int)other.getEnqueueTime() + " this " + (int)this.getEnqueueTime());
        return i;
    }
}
