package mastermind.views;

import mastermind.models.Board;

public class StartView extends SubView {
    public StartView(Board board) {
        super(board);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView(this.board).write();
    }
}
