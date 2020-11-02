package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;

public abstract class Command extends usantatecla.utils.Command {
    protected ActionController actionController;

    protected Command(String title, ActionController actionController) {
        super(title);
        this.actionController = actionController;
    }
}
