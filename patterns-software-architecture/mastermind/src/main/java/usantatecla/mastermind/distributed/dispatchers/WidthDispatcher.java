package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class WidthDispatcher extends Dispatcher {

    public WidthDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((ProposalController)this.acceptorController).getWidth());
    }
}
