package usantatecla.mastermind.distributed;

import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;

public class LogicProxy extends usantatecla.mastermind.controllers.Logic {
    private TCPIP tcpip;

    public LogicProxy() {
        this.tcpip = TCPIP.createClientSocket();
        this.session = new SessionProxy(this.tcpip);
        this.controllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.IN_GAME, new ProposalControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.FINAL, new ResumeControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.EXIT, null);
    }

    @Override
    public void close() {
        this.tcpip.close();
    }
}
