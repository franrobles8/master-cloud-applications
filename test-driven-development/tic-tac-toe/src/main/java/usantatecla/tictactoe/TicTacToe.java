package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.console.ConsoleView;

public abstract class TicTacToe {
    private Logic logic;
    private ConsoleView view;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = this.createView(this.logic);
    }

    protected abstract ConsoleView createView(Logic logic);

    protected void play() {
        this.view.interact();
    }
}
