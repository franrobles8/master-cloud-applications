package usantatecla.draughts.models;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class TurnTest {
    @Test
    public void givenTurnWhiteColorWhenChangeThenChangeColor() {
        Turn turn = new Turn();
        turn.change();
        assertThat(turn.getColor(), is(Color.BLACK));
    }

    @Test
    public void givenTurnWhiteColorWhenChangedTwiceThenColorIsWhite() {
        Turn turn = new Turn();
        turn.change();
        turn.change();
        assertThat(turn.getColor(), is(Color.WHITE));
    }
}
