package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class ResumeController extends usantatecla.mastermind.controllers.ResumeController {

	private SessionImplementation sessionImplementation;

	public ResumeController(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	@Override
	public void resume(boolean newGame) {
		if (newGame) {
			this.sessionImplementation.reset();
		} else {
			this.sessionImplementation.next();
		}
	}

	@Override
	public int getWidth() {
		return this.sessionImplementation.getWidth();
	}

}
