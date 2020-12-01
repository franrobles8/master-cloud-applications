package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    private Console console;

    public CoordinateView() {
        this.console = Console.getInstance();
    }

    public Coordinate read(String title) {
        Coordinate coordinate;
        Error error;
        do {
			this.console.writeln(title);
            int row = this.console.readInt("Row: ") - 1;
            int column = this.console.readInt("Column: ") - 1;
            assert column >= 0 && column <= Coordinate.DIMENSION-1;
            assert row >= 0 && row <= Coordinate.DIMENSION-1;
            coordinate = new Coordinate(row, column);
            error = coordinate.isValid();
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}
