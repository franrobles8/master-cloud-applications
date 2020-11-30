package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;

public class ConsoleView extends usantatecla.tictactoe.views.View {
    private StartView startView;
    private PlayView playView;

    public ConsoleView(Logic logic) {
        this.startView = new StartView(logic);
        this.playView = new PlayView(logic);
    }

    @Override
    protected void start() {
       this.startView.interact();
    }

    @Override
    protected void play() {
        this.playView.interact();
    }

    @Override
    protected boolean isResumed() {
        // To do
        return false;
    }
}
