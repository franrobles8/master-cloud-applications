package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;

public class WhitesDispatcher extends Dispatcher {

    public WhitesDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        this.tcpip.send(((ProposalController)this.acceptorController).getWhites(position));
    }
}
