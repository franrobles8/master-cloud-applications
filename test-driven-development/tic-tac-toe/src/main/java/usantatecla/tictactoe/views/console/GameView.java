package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class GameView {

	private Controller controller;
	private Console console;

	GameView(Controller controller) {
		this.controller = controller;
		this.console = Console.getInstance();
  }

	void write() {
		this.console.writeln(Message.SEPARATOR.toString());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			this.console.write(Message.VERTICAL_LINE_LEFT.toString());
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				new TokenView(this.controller.getToken(new Coordinate(i, j))).write();
				this.console.write(Message.VERTICAL_LINE_CENTERED.toString());
			}
			this.console.writeln(Message.VERTICAL_LINE_RIGHT.toString());
		}
		this.console.writeln(Message.SEPARATOR.toString());
	}

}
