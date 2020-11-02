package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class AttemptsDispatcher extends Dispatcher {

    public AttemptsDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((ProposalController)this.acceptorController).getAttempts());
    }
}
