package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class ConsoleView extends usantatecla.tictactoe.views.View {
    
    private  PlayView playView;
    private  ResumeView resumeView;

    public ConsoleView() {
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);

    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);

    }

    @Override
    public void visit(StartController startController) {
        // TODO Auto-generated method stub

    }
}
