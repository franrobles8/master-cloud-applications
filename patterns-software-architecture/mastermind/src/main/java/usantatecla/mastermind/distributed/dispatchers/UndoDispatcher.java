package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class UndoDispatcher extends Dispatcher {
    public UndoDispatcher(ProposalController proposalController) {
		super(proposalController);
	}

	@Override
	public void dispatch() {
		((ProposalController)this.acceptorController).undo();
	}
}
