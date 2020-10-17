package mastermind.views;

import mastermind.models.Board;

public class ProposedCombinationView {
    
    private Board board;

    ProposedCombinationView(Board board) {
        this.board = board;
    }

    void write() {
        Message.PROPOSE_COMBINATION.write();
        this.board.addProposedCombination();
    }
}
