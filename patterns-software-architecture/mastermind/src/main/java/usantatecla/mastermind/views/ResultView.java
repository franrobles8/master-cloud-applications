package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private ActionController actionController;
	
	ResultView(ActionController actionController){
		this.actionController = actionController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.actionController.getBlacks(i))
				.replaceFirst("#whites", "" + this.actionController.getWhites(i)));
	}

}
