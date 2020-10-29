package usantatecla.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

public class Logic {

	private Session session;
	
	private Map<StateValue, Controller> controllers;

	private TCPIP tcpip;
		
	public Logic(boolean isStandalone) {
		this.tcpip = isStandalone ? null : TCPIP.createClientSocket();
		this.session = new Session(this.tcpip);
		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session, this.tcpip));
		this.controllers.put(StateValue.IN_GAME, new ProposalController(this.session, this.tcpip));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.session, this.tcpip));
		this.controllers.put(StateValue.EXIT, null);
	}
	
	public Controller getController() {
		return this.controllers.get(this.session.getValueState());
	}
	
	public void close() {
		this.tcpip.close();
	}
}
