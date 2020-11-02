package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	void interact(ProposalController proposalController) {
		new ProposalMenu(proposalController).execute();
	}
}
