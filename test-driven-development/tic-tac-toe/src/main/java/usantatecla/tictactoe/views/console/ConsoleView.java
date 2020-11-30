package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;

public class ConsoleView extends usantatecla.tictactoe.views.View {
    private StartView startView;

    public ConsoleView(Logic logic) {
        this.startView = new StartView(logic);
    }

    @Override
    protected void start() {
       this.startView.interact();
    }

    @Override
    protected void play() {
        // To do
    }

    @Override
    protected boolean isResumed() {
        // To do
        return false;
    }
}
