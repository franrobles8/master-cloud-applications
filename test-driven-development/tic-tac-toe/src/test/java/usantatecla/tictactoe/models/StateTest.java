package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {
    private State state;

    @BeforeEach
    public void before() {
        this.state = new State();
    }

    @Test
    public void givenStateWhenGetValueStateThenReturnStateValue() {
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void givenStateWhenNextThenChangeToNextStateValue() {
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.RESUME));
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.EXIT));
    }
}
