package mastermind;

import java.util.ArrayList;

class SecretCombination extends Combination {

	SecretCombination() {
		super(generateRandomPositions());
	}

	private static ArrayList<Color> generateRandomPositions() {
		ArrayList<Color> colors = new ArrayList<>(Board.MAX_PEG_COLORS);
		for (int i = 0; i < Board.MAX_PEG_COLORS; i++) {
			Color randomColor = Color.getRandomInstance();
			while (colors.contains(randomColor)) {
				randomColor = Color.getRandomInstance();
			}
			colors.add(randomColor);
		}
		return colors;
	}
}
