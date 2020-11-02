package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private ActionController actionController;

	AttemptsView(ActionController actionController) {
		this.actionController = actionController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.actionController.getAttempts()));
	}

}
