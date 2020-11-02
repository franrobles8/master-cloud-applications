package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class ProposalDispatcher extends Dispatcher {
    public ProposalDispatcher(ProposalController proposalController) {
		super(proposalController);
	}

    @Override
    public void dispatch() {
        List<Color> colors = new ArrayList<Color>();
        for (int i=0; i<((ProposalController)this.acceptorController).getWidth(); i++) {
            colors.add(this.tcpip.receiveColor());
        }
        ((ProposalController)this.acceptorController).addProposedCombination(colors);
    }
}
