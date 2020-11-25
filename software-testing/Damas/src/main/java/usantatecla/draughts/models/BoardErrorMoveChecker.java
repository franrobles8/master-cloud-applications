package usantatecla.draughts.models;

public class BoardErrorMoveChecker extends ErrorMoveChecker {

    private Board board;

    public BoardErrorMoveChecker(Board board) {
        this.board = board;
    }

    public Error check(int pair, Coordinate... coordinates) {
        if (this.board.isEmpty(coordinates[pair]))
            return Error.EMPTY_ORIGIN;
        if (!this.board.isEmpty(coordinates[pair + 1]))
            return Error.NOT_EMPTY_TARGET;
        return this.checkNext(pair, coordinates);
    }
}
