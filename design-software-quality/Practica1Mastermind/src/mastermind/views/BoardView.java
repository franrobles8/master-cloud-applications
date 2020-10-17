package mastermind.views;

import java.util.ArrayList;

import mastermind.models.Board;
import mastermind.models.ProposedCombination;

public class BoardView {
    private Board board;

    BoardView(Board board) {
        this.board = board;
    }

    void write() {
        do {
            ProposedCombination proposedCombination = new ProposedCombination(new ArrayList<>());
            ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
            proposedCombinationView.read();
            this.board.addProposedCombination(proposedCombination);
            new ResultView(this.board).write();
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
