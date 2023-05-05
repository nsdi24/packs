package ch.ethz.systems.netbench.xpt.udp;

public interface UdpPriorityHeader extends UdpHeader {

    /**
     * Retrieve the priority of the packet.
     *
     * @return  Packet priority
     */
    long getPriority();

    /**
     * Increase the priority of the packet.
     */
    void increasePriority();

    /**
     * Set the current priority of the packet.
     *
     * @param val   Priority value
     */
    void setPriority(long val);

}
