package ch.ethz.systems.netbench.ext.basic;

import ch.ethz.systems.netbench.core.Simulator;
import ch.ethz.systems.netbench.core.log.SimulationLogger;
import ch.ethz.systems.netbench.core.network.*;
import ch.ethz.systems.netbench.ext.basic.IpHeader;

import java.util.concurrent.LinkedBlockingQueue;

public class TailDropOutputPort extends OutputPort {

    private final long maxQueueSizeBits;

    TailDropOutputPort(NetworkDevice ownNetworkDevice, NetworkDevice targetNetworkDevice, Link link, long maxQueueSizeBytes) {
        super(ownNetworkDevice, targetNetworkDevice, link, new LinkedBlockingQueue<Packet>());
        this.maxQueueSizeBits = maxQueueSizeBytes * 8L;
    }

    /**
     * Enqueue the given packet.
     * Drops it if the queue is full (tail drop).
     *
     * @param packet    Packet instance
     */
    @Override
    public void enqueue(Packet packet) {

        // Convert to IP packet
        IpHeader ipHeader = (IpHeader) packet;

        // Tail-drop enqueue
        if (getBufferOccupiedBits() + ipHeader.getSizeBit() <= maxQueueSizeBits) {
        //if (this.queue.size() + 1 <= maxQueueSizeBits / 8 / 1460) {

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
                increaseBufferOccupiedBits(packet.getSizeBit());
                getQueue().add(packet);
                getLogger().logQueueState(getQueue().size(), getBufferOccupiedBits());
            }

        } else {
            SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED");
            if (ipHeader.getSourceId() == this.getOwnId()) {
                SimulationLogger.increaseStatisticCounter("PACKETS_DROPPED_AT_SOURCE");
            }
        }
    }
}
