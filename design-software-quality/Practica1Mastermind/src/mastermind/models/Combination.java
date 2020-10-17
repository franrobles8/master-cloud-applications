package mastermind.models;

import java.util.List;

public class Combination {
	private static final int MAX_PEG_COLORS = 4;
	
	private List<Color> colors;

	Combination(List<Color> colors) {
		this.colors = colors;
	}

	public List<Color> getColors() {
		return colors;
	}

	public static int getMaxPegColors() {
		return MAX_PEG_COLORS;
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
