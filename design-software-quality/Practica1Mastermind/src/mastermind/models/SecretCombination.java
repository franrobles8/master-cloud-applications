package mastermind.models;

import java.util.ArrayList;

class SecretCombination extends Combination {

	SecretCombination() {
		super(generateRandomPositions());
	}

	private static ArrayList<Color> generateRandomPositions() {
		ArrayList<Color> colors = new ArrayList<>(Combination.getMaxPegColors());
		for (int i = 0; i < Combination.getMaxPegColors(); i++) {
			Color randomColor = Color.getRandomInstance();
			while (colors.contains(randomColor)) {
				randomColor = Color.getRandomInstance();
			}
			colors.add(randomColor);
		}
		return colors;
	}
}
