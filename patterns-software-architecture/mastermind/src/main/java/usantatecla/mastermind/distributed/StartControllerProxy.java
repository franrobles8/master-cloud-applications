package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class StartControllerProxy extends StartController {
    private TCPIP tcpip;

    public StartControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start() {
        this.tcpip.send(FrameType.START.name());
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.WIDTH.name());
        return this.tcpip.receiveInt();
    }
}
