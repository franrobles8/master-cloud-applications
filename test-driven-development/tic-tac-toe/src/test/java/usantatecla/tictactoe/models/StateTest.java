package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeAll;
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
        StateValue stateValue = this.state.getValueState();
        assertThat(stateValue, is(StateValue.INITIAL));
    }
}
