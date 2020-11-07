package usantatecla.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class GameTest {

    private Game game;

    @Before
    public void before() {
        game = new Game(new Board());
        game.reset();
    }

    @Test
    public void moveReturnsEmptyOriginErrorTest() {
        assertThat(game.move(new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1) }), is(Error.EMPTY_ORIGIN));
    }

    @Test
    public void moveReturnsOppositePieceErrorTest() {
        assertThat(game.move(new Coordinate[] { new Coordinate(1, 2), new Coordinate(2, 2) }),
                is(Error.OPPOSITE_PIECE));
    }

    @Test
    public void moveReturnsNotEmptyTargetErrorTest() {
        assertThat(game.move(new Coordinate[] { new Coordinate(6, 1), new Coordinate(5, 0) }),
                is(Error.NOT_EMPTY_TARGET));
    }

    @Test
    public void moveSuccessfulTest() {
        Color actualTurnColor = game.getTurnColor();
        game.move(new Coordinate[] { new Coordinate(5, 0), new Coordinate(4, 1) });
        Color resultTurnColor = game.getTurnColor();
        assertThat(resultTurnColor, not(is(actualTurnColor)));
    }

    @Test
    public void givenCoordinatesWhenOneIsNotBlockedReturnsFalse() {
        assertFalse(game.isBlocked());
    }

    @Test
    public void givenCoordinatesWhenAllAreBlockedReturnTrue() {
        Board preparedBlockedBoard = new Board();
        preparedBlockedBoard.put(new Coordinate(0, 1), new Pawn(Color.WHITE));
        Game newGame = new Game(preparedBlockedBoard);
        assertTrue(newGame.isBlocked());
    }

    @Test
    public void givenCoordinatesWithTurnColorWhenCancelRemoveThemAndChangeTurn() {
        List<Coordinate> turnColorCoordinates = new ArrayList<>();
        Color turnColor = game.getTurnColor();
        game.cancel();
        for(int i = 0 ; i < Coordinate.getDimension(); i++) {
            for(int j = 0 ; j < Coordinate.getDimension(); j++) {
                if(game.getColor(new Coordinate(i, j)) == turnColor)
                    turnColorCoordinates.add(new Coordinate(i, j));
            }
        }
        assertThat(turnColorCoordinates.size(), is(0));
        assertThat(game.getTurnColor(), is(Color.BLACK));
    }
}
