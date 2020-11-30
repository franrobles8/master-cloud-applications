package usantatecla.tictactoe.models;

public class State {
    private StateValue stateValue;

    public State() {
        this.stateValue = StateValue.INITIAL;
    }

    public void reset() {
        // To do
    }

    public void next() {
        // To do
    }

    public StateValue getValueState() {
        return this.stateValue;
    }
}
