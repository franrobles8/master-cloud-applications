package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.types.Error;

class PlayView extends SubView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            if (!this.logic.isBoardComplete()) {
                this.put();
            } else {
                this.move();
            }
            new GameView(this.logic).write();
        } while (!this.logic.isTicTacToe());
        new TokenView(this.logic.getToken()).write();
        Message.PLAYER_WIN.writeln();
    }

    private void put() {
        boolean isUser = this.logic.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
            } else {
                coordinate = createRandomCoordinate();
            }
            error = this.logic.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.logic.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView().read(Message.COORDINATE_TO_REMOVE.toString());
                target = new CoordinateView().read(Message.COORDINATE_TO_MOVE.toString());
            } else {
                origin = createRandomCoordinate();
                target = createRandomCoordinate();
            }
            error = this.logic.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    Coordinate createRandomCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

}
