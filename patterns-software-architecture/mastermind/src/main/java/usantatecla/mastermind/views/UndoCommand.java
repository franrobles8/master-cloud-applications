package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;

public class UndoCommand extends Command{
    UndoCommand(ActionController actionController) {
        super(MessageView.UNDO_COMMAND.getMessage(), actionController);
    }

    @Override
    protected void execute() {
        this.actionController.undo();
    }

    @Override
    protected boolean isActive() {
        return this.actionController.undoable();
    }
}
