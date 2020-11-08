package usantatecla.draughts.controllers;

import org.junit.Test;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ControllerTest {
    @Test
    public void givenACoordinateWhenIsInGameReturnsColor() {
        Game game = new GameBuilder().row(0, " n      ").build();
        State state = new State();
        assertThat(new Controller(game, state).getColor(new Coordinate(0, 1)), is(Color.BLACK));
    }

    @Test
    public void returnsDimension() {
        Game game = new GameBuilder().build();
        State state = new State();
        assertThat(new Controller(game, state).getDimension(), is(game.getDimension()));
    }
}
