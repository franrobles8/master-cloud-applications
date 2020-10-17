package mastermind.views;

import mastermind.models.Board;

public class BoardView {
    private Board board;

    BoardView(Board board) {
        this.board = board;
    }

    void write() {
        do {
            new ProposedCombinationView(this.board).write();
            new ResultView(board).write();
        } while(!this.board.isGameFinished());
        
        if (this.board.isGameFinished()) {
			if (this.board.isMasterMind()) {
				Message.PLAYER_WIN.writeln();
			} else {
				Message.PLAYER_LOSE.writeln();
			}
		}
    }
}
