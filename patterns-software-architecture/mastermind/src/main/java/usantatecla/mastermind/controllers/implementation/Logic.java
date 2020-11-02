package usantatecla.mastermind.controllers.implementation;


import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.models.StateValue;

public class Logic extends usantatecla.mastermind.controllers.Logic {

	protected StartController startController;
	protected ProposalController playController;
	protected ResumeController resumeController;

	public Logic() {
		this.session = new SessionImplementation();
		this.startController = new StartController(this.session);
		this.playController = new ProposalController(this.session);
		this.resumeController = new ResumeController(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startController);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playController);
		this.acceptorControllers.put(StateValue.RESUME, this.resumeController);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
