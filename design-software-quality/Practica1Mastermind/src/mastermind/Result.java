package mastermind;

class Result {
	private static final int MAX_POSITIONS = 4;
	private int nBlacks;
	private int nWhites;

	Result(SecretCombination secretCombination, ProposedCombination proposedCombination) {
		fillBlackAndWhites(secretCombination, proposedCombination);
	}

	private void fillBlackAndWhites(SecretCombination secretCombination, ProposedCombination proposedCombination) {
		this.nBlacks = getMatchedPositions(secretCombination, proposedCombination);
		this.nWhites = getContainedPositions(secretCombination, proposedCombination);
	}

	private int getMatchedPositions(SecretCombination secretCombination, ProposedCombination proposedCombination) {
		int nMatches = 0;
		for (int i = 0; i < MAX_POSITIONS; i++) {
			nMatches += (secretCombination.getColors().get(i) == proposedCombination.getColors().get(i)) ? 1 : 0;
		}
		return nMatches;
	}

	private int getContainedPositions(SecretCombination secretCombination, ProposedCombination proposedCombination) {
		int nContained = 0;
		for (int i = 0; i < MAX_POSITIONS; i++) {
			for (int j = 0; j < MAX_POSITIONS; j++) {
				boolean isEqualColor = proposedCombination.getColors().get(i) == secretCombination.getColors().get(j);
				nContained += isEqualColor && i != j ? 1 : 0;
			}
		}
		return nContained;
	}

	public boolean isWinnerCombination() {
		return this.nBlacks == MAX_POSITIONS;
	}

	@Override
	public String toString() {
		return this.nBlacks + " blacks and " + this.nWhites + " whites";
	}
}
