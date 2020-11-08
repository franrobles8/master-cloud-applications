package usantatecla.draughts.models;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class StateTest {
    @Test
    public void givenStateValueWhenCallingNextChangesStateToNext() {
        State state = new State();
        for (StateValue value : StateValue.values()) {
            if (value != StateValue.EXIT) {
                StateValue expectedNextState = StateValue.values()[value.ordinal() + 1];
                state.next();
                assertThat(state.getValueState(), is(expectedNextState));
            }
        }
    }

    @Test
    public void givenStateValueWhenCallingResetChangesStateToInitial() {
        State state = new State();
        state.next();
        state.reset();
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }
}
