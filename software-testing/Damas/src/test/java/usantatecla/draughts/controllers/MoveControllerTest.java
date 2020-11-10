package usantatecla.draughts.controllers;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;
import static org.hamcrest.CoreMatchers.is;

public class MoveControllerTest {
    @Test
    public void givenMovementWhenIsSuccessfulAndBlockedThenChangeState() {
        Game game = new GameBuilder().row(0, " b      ").build();
        State state = new State();
        MoveController moveController = new MoveController(game, state);
        moveController.move(new Coordinate[] {new Coordinate(1, 2), new Coordinate(0, 3)});
        assertTrue(moveController.game.isBlocked());
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }
}
