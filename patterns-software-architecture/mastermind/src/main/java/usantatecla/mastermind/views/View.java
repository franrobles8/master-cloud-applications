package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.*;

public class View implements ControllersVisitor {


	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(ProposalController proposalController) {
		this.proposalView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}
