package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.console.ConsoleView;

public abstract class TicTacToe {
    private Logic logic;
    private ConsoleView view;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract ConsoleView createView();

    protected void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
		} while (controller != null);
    }
}
