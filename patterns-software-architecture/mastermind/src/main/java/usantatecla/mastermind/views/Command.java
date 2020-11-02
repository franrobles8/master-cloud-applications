package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.controllers.ProposalController;

public abstract class Command extends usantatecla.utils.Command {
    protected ProposalController proposalController;

    protected Command(String title, ProposalController proposalController) {
        super(title);
        this.proposalController = proposalController;
    }
}
