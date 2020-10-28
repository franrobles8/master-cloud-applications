package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.utils.Menu;

public class ProposalMenu extends Menu {
    ProposalMenu(ProposalController proposalController) {
        this.add(new ProposalCommand(proposalController));
        this.add(new UndoCommand(proposalController));
        this.add(new RedoCommand(proposalController));
    }
}
