package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class ProposalDispatcher extends Dispatcher {
    public ProposalDispatcher(ProposalController proposalController) {
		super(proposalController);
	}

    @Override
    public void dispatch() {
        this.tcpip.send(((ProposalController) this.acceptorController).addProposedCombination(null));
    }
}
