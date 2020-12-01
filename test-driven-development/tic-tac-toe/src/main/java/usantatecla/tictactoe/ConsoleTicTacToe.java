package usantatecla.tictactoe;

import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe extends TicTacToe {

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

	@Override
	protected ConsoleView createView(){
		return new ConsoleView();
	}
}
