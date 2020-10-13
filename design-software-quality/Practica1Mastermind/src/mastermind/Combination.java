package mastermind;

import java.util.ArrayList;

public class Combination {
	private ArrayList<Color> colors;

	Combination(ArrayList<Color> colors) {
		this.colors = colors;
	}

	public ArrayList<Color> getColors() {
		return colors;
	}

	@Override
	public String toString() {
		String combination = "";
		for (Color color : this.colors) {
			combination += color.getColor();
		}
		return combination;
	}
}
