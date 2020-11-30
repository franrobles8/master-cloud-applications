package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class GameView {

	private Logic logic;

	GameView(Logic logic) {
    this.logic = logic;
  }

	void write() {
		Console.getInstance().writeln(Message.SEPARATOR.toString());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			Console.getInstance().write(Message.VERTICAL_LINE_LEFT.toString());
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				new TokenView(this.logic.getToken(new Coordinate(i, j))).write();
				Console.getInstance().write(Message.VERTICAL_LINE_CENTERED.toString());
			}
			Console.getInstance().writeln(Message.VERTICAL_LINE_RIGHT.toString());
		}
		Console.getInstance().writeln(Message.SEPARATOR.toString());
	}

}
