package mastermind;

import utils.YesNoDialog;

class MasterMind {
	private void play() {
		do {
			Message.TITTLE.writeln();
			new Board();
		} while (this.isResumedGame());
	}

	private boolean isResumedGame() {
		return new YesNoDialog().read(Message.RESUME.toString());
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}