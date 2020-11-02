package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ProposalController;

public class RedoCommand extends Command {
    RedoCommand(ProposalController proposalController) {
        super(MessageView.REDO_COMMAND.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        this.proposalController.redo();
    }

    @Override
    protected boolean isActive() {
        return this.proposalController.redoable();
    }
}
