package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private AcceptorController controller;
	
	SecretCombinationView(AcceptorController controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
