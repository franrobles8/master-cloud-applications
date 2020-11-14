package usantatecla.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.builders.game.GameBuilder;

public class PlayControllerTest {
    
    private PlayController playController;

    @Test
    public void givenPlayControllerThenMove() {
        Game game = new GameBuilder().build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(5, 6);
        Coordinate target = new Coordinate(4, 7);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertFalse(game.isBlocked());
    }

    @Test
    public void givenPlayControllerWhenFinishThenIsBlocked() {
        Game game = new GameBuilder().row(2, "b       ").row(1, " n      ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(0, 2);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertTrue(game.isBlocked());
    }

    @Test
    public void givenPlayControllerWhenNoMovementsThenIsBlocked() {
        Game game = new GameBuilder()
                        .row(0, "n       ")
                        .row(1, " b      ")
                        .row(2, "  b     ")
                        .row(7, "b       ")
                        .build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = new Coordinate(6, 1);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertTrue(game.isBlocked());
    }

    @Test
    public void givenPlayControllerWhenCancelThenGameIsNotBlocked() {
        Game game = new GameBuilder().build();
        playController = new PlayController(game, new State());
        playController.cancel();
        assertEquals(Color.BLACK, playController.getColor());
        assertFalse(game.isBlocked());
    }
}
