package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

class ErrorView extends usantatecla.tictactoe.views.ErrorView {

	private Console console;

	ErrorView(Error error) {
		super(error);
		this.console = Console.getInstance();
	}
	
	void writeln() {
		if (!error.isNull()){
			this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}
