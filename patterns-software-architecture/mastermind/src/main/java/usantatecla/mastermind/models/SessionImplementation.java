package usantatecla.mastermind.models;

import java.util.List;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class SessionImplementation implements Session {
    private Game game;
    private State state;
    private GameRegistry registry;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new GameRegistry(this.game);
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
        this.registry = new GameRegistry(this.game);
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
        this.registry.register();
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean undoable() {
        return this.registry.isUndoable();
    }

    public boolean redoable() {
        return this.registry.isRedoable();
    }

    public Error getProposedCombinationError(List<Color> colors) {
        return this.game.getProposedCombinationError(colors);
    }
}
