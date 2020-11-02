package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.utils.Menu;

public class ProposalMenu extends Menu {
    ProposalMenu(ProposalController actionController) {
        this.add(new ProposalCommand(actionController));
        this.add(new UndoCommand(actionController));
        this.add(new RedoCommand(actionController));
    }
}
