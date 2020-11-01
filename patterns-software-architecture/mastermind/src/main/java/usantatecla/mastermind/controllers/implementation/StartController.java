package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class StartController extends usantatecla.mastermind.controllers.StartController {

	SessionImplementation sessionImplementation;

	public StartController(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}
	
	@Override
	public void start() {
		this.sessionImplementation.next();		
	}

	@Override
	public int getWidth() {
		return this.sessionImplementation.getWidth();
	}
}
