package ch.ethz.systems.netbench.xpt.aifotransport;

import ch.ethz.systems.netbench.core.network.Event;
import ch.ethz.systems.netbench.core.network.Socket;

public class AIFOUDPSendPacketEvent extends Event {
    private final Socket udpsocket;
    public AIFOUDPSendPacketEvent(long timeFromNowNS, Socket udpsocket) {
        super(timeFromNowNS);
        this.udpsocket = udpsocket;
    }
    @java.lang.Override
    public void trigger() {
        this.udpsocket.start();
    }
}
