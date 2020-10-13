package mastermind;

import utils.Console;

class Board {
	private static final int MAX_PROPOSED_COMBINATIONS = 10;
	protected static final int MAX_PEG_COLORS = 4;
	private SecretCombination secretCombination;
	private ProposedCombination[] proposedCombinations;
	private Result[] results;
	private int nProposedCombinations;
	private boolean isGameFinished;
	private boolean isMasterMind;

	Board() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ProposedCombination[MAX_PROPOSED_COMBINATIONS];
		this.isGameFinished = false;
		this.isMasterMind = false;
		this.results = new Result[MAX_PROPOSED_COMBINATIONS];

		do {
			Message.PROPOSE_COMBINATION.write();
			this.proposedCombinations[nProposedCombinations] = new ProposedCombination();
			this.results[nProposedCombinations] = new Result(secretCombination,
					this.proposedCombinations[nProposedCombinations]);
			isMasterMind = this.results[nProposedCombinations].isWinnerCombination();
			isGameFinished = (nProposedCombinations + 1 == MAX_PROPOSED_COMBINATIONS) || isMasterMind;
			nProposedCombinations++;
			this.write();
		} while (!isGameFinished);
	}

	private boolean isMasterMind() {
		return isMasterMind;
	}

	public void write() {
		Console.instance().writeln(nProposedCombinations + " attempt(s):");
		Message.X_ROW_COLORS.writeln();
		for (int i = 0; i < nProposedCombinations; i++) {
			Console.instance().writeln(this.proposedCombinations[i] + " --> " + this.results[i]);
		}
		if (isGameFinished) {
			if (this.isMasterMind()) {
				Message.PLAYER_WIN.writeln();
			} else {
				Message.PLAYER_LOSE.writeln();
			}
		}
	}
}
