package mastermind;

import mastermind.models.Board;
import mastermind.views.View;

class MasterMind {
	private Board board;
	private View view;

	MasterMind() {
		this.board = new Board();
		this.view = new View(this.board);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}