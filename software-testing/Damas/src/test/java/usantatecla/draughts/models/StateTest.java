package usantatecla.draughts.models;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class StateTest {
    private State state;

    @Before
    public void before() {
        this.state = new State();
    }

    @Test
    public void givenStateValueWhenCallingNextThenChangesStateToNext() {
        for (StateValue value : StateValue.values()) {
            if (value != StateValue.EXIT) {
                StateValue expectedNextState = StateValue.values()[value.ordinal() + 1];
                this.state.next();
                assertThat(this.state.getValueState(), is(expectedNextState));
            }
        }
    }

    @Test
    public void givenStateValueWhenCallingResetThenChangesStateToInitial() {
        state.next();
        state.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }
}
