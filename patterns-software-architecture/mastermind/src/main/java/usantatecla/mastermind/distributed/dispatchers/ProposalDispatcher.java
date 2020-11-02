package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class ProposalDispatcher extends Dispatcher {
    public ProposalDispatcher(PlayController playController) {
		super(playController);
	}

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController) this.acceptorController).addProposedCombination(null));
    }
}
