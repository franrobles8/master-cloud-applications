package mastermind.views;

import mastermind.models.Board;
import utils.YesNoDialog;

public class ResumeView extends SubView {
    public ResumeView(Board board) {
        super(board);
    }

    boolean interact() {
        boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
        if(isResumed) {
            this.board.reset();
        }
        return isResumed;
    }
}
