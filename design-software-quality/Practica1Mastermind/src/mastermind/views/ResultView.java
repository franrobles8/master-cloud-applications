package mastermind.views;

import mastermind.models.Board;
import utils.Console;

public class ResultView {
    private Board board;

    ResultView(Board board) {
        this.board = board;
    }

    void write() {
        Console.instance().writeln(this.board.getNProposedCombinations() + " attempt(s):");
        Message.X_ROW_COLORS.writeln();
        for (int i = 0; i < this.board.getNProposedCombinations(); i++) {
            Console.instance().writeln(this.board.getProposedCombinations()[i] + " --> " + this.board.getResults()[i]);
		}
    }
}
