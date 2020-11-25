package usantatecla.draughts.models;

public class TurnErrorMoveChecker extends ErrorMoveChecker {
    private Board board;
    private Turn turn;

    public TurnErrorMoveChecker(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
    }

    public Error check(int pair, Coordinate... coordinates) {
        if (this.turn.getOppositeColor() == this.board.getColor(coordinates[pair]))
            return Error.OPPOSITE_PIECE;
        return this.checkNext(pair, coordinates);
    }
}
