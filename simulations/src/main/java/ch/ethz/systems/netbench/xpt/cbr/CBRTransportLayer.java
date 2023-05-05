package ch.ethz.systems.netbench.xpt.cbr;

import ch.ethz.systems.netbench.core.network.Socket;
import ch.ethz.systems.netbench.core.network.TransportLayer;

public class CBRTransportLayer extends TransportLayer {

    private boolean randomEnabled;
    private boolean ranksEnabled;
    private String rankDistribution;
    private long rankBound;

    public CBRTransportLayer(int identifier, boolean randomEnabled, boolean ranksEnabled, String rankDistribution, long rankBound) {
        super(identifier);
        this.randomEnabled = randomEnabled;
        this.ranksEnabled = ranksEnabled;
        this.rankDistribution = rankDistribution;
        this.rankBound = rankBound;
    }

    @Override // Not used
    protected Socket createSocket(long flowId, int destinationId, long flowSizeByte) {
        return null;
    }

    public void startCBRFlow(long flowId, int destinationId,
            int packetSize, Float rate, long timeStart, long timeEnd) {

        // Create new outgoing socket
        CBRSocket socket = new CBRSocket(this, flowId, this.identifier, destinationId,
             packetSize, rate,  timeStart, timeEnd, randomEnabled, ranksEnabled, rankDistribution, rankBound);

        // Start the socket off as initiator
        socket.markAsSender();
        socket.start();
    }

}
