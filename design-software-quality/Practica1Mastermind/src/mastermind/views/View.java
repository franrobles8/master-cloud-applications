package mastermind.views;

import mastermind.models.Board;

public class View {
    private StartView startView;
    private ResumeView resumeView;

    public View(Board board) {
        this.startView = new StartView(board);
        this.resumeView = new ResumeView(board);
    }

    public void interact() {
        do {
            this.startView.interact();
        } while(this.resumeView.interact());
    }
}
