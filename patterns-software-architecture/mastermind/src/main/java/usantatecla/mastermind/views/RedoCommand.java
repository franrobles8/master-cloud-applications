package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;

public class RedoCommand extends Command {
    RedoCommand(ActionController actionController) {
        super(MessageView.REDO_COMMAND.getMessage(), actionController);
    }

    @Override
    protected void execute() {
        this.actionController.redo();
    }

    @Override
    protected boolean isActive() {
        return this.actionController.redoable();
    }
}
