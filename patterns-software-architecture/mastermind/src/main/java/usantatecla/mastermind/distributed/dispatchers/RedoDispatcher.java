package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class RedoDispatcher extends Dispatcher {
    public RedoDispatcher(ProposalController proposalController) {
		super(proposalController);
	}

	@Override
	public void dispatch() {
		((ProposalController)this.acceptorController).redo();
	}
}
