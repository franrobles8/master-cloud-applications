package usantatecla.mastermind.views;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.ActionController;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.WithConsoleView;

class ProposedCombinationView extends WithConsoleView {
	
	private ActionController actionController;
	
	ProposedCombinationView(ActionController actionController) {
		this.actionController = actionController;
	}
	
	void write(int position) {
		for (Color color : this.actionController.getColors(position)) {
			new usantatecla.mastermind.views.ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(usantatecla.mastermind.views.ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
