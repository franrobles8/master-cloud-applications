package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class MastermindDispatcher extends Dispatcher {
    public MastermindDispatcher(ProposalController proposalController) {
		super(proposalController);
	}

    @Override
    public void dispatch() {
        this.tcpip.send(((ProposalController) this.acceptorController).isFinished());
    }
}
