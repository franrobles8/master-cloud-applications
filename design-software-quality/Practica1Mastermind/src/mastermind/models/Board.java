package mastermind.models;

public class Board {
	private static final int MAX_PROPOSED_COMBINATIONS = 10;
	private SecretCombination secretCombination;
	private ProposedCombination[] proposedCombinations;
	private Result[] results;
	private int nProposedCombinations;
	private boolean isGameFinished;
	private boolean isMasterMind;

	public Board() {
		this.reset();
	}

	public boolean isMasterMind() {
		return isMasterMind;
	}

	public boolean isGameFinished() {
		return isGameFinished;
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations[nProposedCombinations] = proposedCombination;
		this.addResult();
		this.isMasterMind = this.results[nProposedCombinations].isWinnerCombination();
		this.isGameFinished = (nProposedCombinations + 1 == MAX_PROPOSED_COMBINATIONS) || isMasterMind;
		this.nProposedCombinations++;
	}

	private void addResult() {
		this.results[nProposedCombinations] = new Result(secretCombination, this.proposedCombinations[nProposedCombinations]);
	}

	public ProposedCombination[] getProposedCombinations() {
		return proposedCombinations;
	}

	public int getNProposedCombinations() {
		return nProposedCombinations;
	}

	public Result[] getResults() {
		return results;
	}

	public void reset() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ProposedCombination[MAX_PROPOSED_COMBINATIONS];
		this.isGameFinished = false;
		this.isMasterMind = false;
		this.results = new Result[MAX_PROPOSED_COMBINATIONS];
		this.nProposedCombinations = 0;
	}
}
