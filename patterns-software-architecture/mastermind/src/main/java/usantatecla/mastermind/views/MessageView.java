package usantatecla.mastermind.views;

import usantatecla.utils.Console;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	PROPOSAL_COMMAND("Do a proposal"), 
	UNDO_COMMAND("Undo previous action"), 
	REDO_COMMAND("Redo previous action");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void writeln() {
		new Console().writeln(this.message);
	}
}
