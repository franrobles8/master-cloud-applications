package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

public class TokenView {

	private Token token;
	private Console console;

	TokenView(Token token){
		this.token = token;
		this.console = Console.getInstance();
	}

	void write() {
		this.console.write(token.toString());
	}

}
