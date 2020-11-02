package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationErrorDispatcher extends Dispatcher {

    public ProposedCombinationErrorDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        List<Color> colors = new ArrayList<Color>();
        for (int i=0; i<((ProposalController) this.acceptorController).getWidth(); i++) {
            colors.add(this.tcpip.receiveColor());
        }
        this.tcpip.send(((ProposalController)
                this.acceptorController).getProposedCombinationError(colors));
    }
}
