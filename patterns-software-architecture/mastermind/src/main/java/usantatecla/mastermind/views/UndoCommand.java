package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ProposalController;

public class UndoCommand extends Command{
    UndoCommand(ProposalController proposalController) {
        super(MessageView.UNDO_COMMAND.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        this.proposalController.undo();
    }

    @Override
    protected boolean isActive() {
        return this.proposalController.undoable();
    }
}
