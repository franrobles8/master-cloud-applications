package usantatecla.mastermind.models;

import java.util.List;

import usantatecla.mastermind.types.Color;

public class Session {
    private Game game;
    private State state;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.game.clear();
        this.state.reset();
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
    }

    public int getWidth() {
        return this.game.getWidth();
    }
}
