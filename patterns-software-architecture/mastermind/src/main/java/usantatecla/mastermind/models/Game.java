package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<>();
		this.results = new ArrayList<>();
		this.attempts = 0;
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		return !this.results.isEmpty() && this.results.get(this.attempts-1).isWinner();
	}

	public boolean isFinished() {
		return this.isLooser() || this.isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	private List<ProposedCombination> getProposedCombinations() {
		return this.proposedCombinations;
	}

	private List<Result> getResults() {
		return this.results;
	}

	public GameMemento createMemento() {
		return new GameMemento(this);
	}

	public void set(GameMemento memento) {
		this.proposedCombinations = memento.getGame().getProposedCombinations();
		this.attempts = memento.getGame().getAttempts();
		this.results = memento.getGame().getResults();
	}

	public Error getProposedCombinationError(List<Color> colors) {	
		if (colors.size() != Combination.getWidth()) {
			return Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					return Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							return Error.DUPLICATED;
						}
					}
				}				
			}
		}
		return Error.NULL;
	}
}
