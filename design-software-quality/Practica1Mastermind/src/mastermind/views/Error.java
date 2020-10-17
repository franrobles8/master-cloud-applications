package mastermind.views;

import utils.Console;
import mastermind.models.Color;

enum Error {
	MUST_CONTAIN_DIFFERENT_COLORS("The proposed combination must contain different colors."), 
	MUST_CONTAIN_VALID_COLORS("The proposed combination must contain colors present in [" + 
								String.valueOf(Color.getAllColorInitials()) + "]"), 
	NULL_ERROR;

	private String message;

	Error() {
	}

	Error(String message) {
		this.message = message;
	}

	void writeln() {
		if (this != Error.NULL_ERROR) {
			Console.instance().writeln(this.message);
		}
	}

}
