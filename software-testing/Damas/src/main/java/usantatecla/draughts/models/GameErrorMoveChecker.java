package usantatecla.draughts.models;

public class GameErrorMoveChecker extends ErrorMoveChecker {
    private Board board;
    private Turn turn;

    public GameErrorMoveChecker(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
    }

    private ErrorMoveChecker build() {
        return new BoardErrorMoveChecker(board)
				.link(new TurnErrorMoveChecker(board, turn));
    }

    public Error check(int pair, Coordinate... coordinates) {
        return this.build().check(pair, coordinates);
    }
}
