package usantatecla.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class GameTest {

    @Test
    public void givenMovementWhenEmptyOriginThenReturnsEmptyOriginError() {
        assertThat(new GameBuilder().build().move(new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1) }),
                is(Error.EMPTY_ORIGIN));
    }

    @Test
    public void givenMovementWhenSamePieceTargetThenReturnsOppositePieceError() {
        assertThat(new GameBuilder().build().move(new Coordinate[] { new Coordinate(1, 2), new Coordinate(2, 2) }),
                is(Error.OPPOSITE_PIECE));
    }

    @Test
    public void givenMovementWhenOccupiedTargetThenReturnsNotEmptyTargetError() {
        assertThat(new GameBuilder().build().move(new Coordinate[] { new Coordinate(6, 1), new Coordinate(5, 0) }),
                is(Error.NOT_EMPTY_TARGET));
    }

    @Test
    public void givenMovementWhenIsValidThenMovesSuccessfully() {
        Game game = new GameBuilder().build();
        Color actualTurnColor = game.getTurnColor();
        game.move(new Coordinate[] { new Coordinate(5, 0), new Coordinate(4, 1) });
        Color resultTurnColor = game.getTurnColor();
        assertThat(resultTurnColor, not(is(actualTurnColor)));
    }

    @Test
    public void givenCoordinatesWhenOneIsNotBlockedThenReturnsFalse() {
        assertFalse(new GameBuilder().build().isBlocked());
    }

    @Test
    public void givenCoordinatesWhenAllAreBlockedThenReturnTrue() {
        GameBuilder gameBuilder = new GameBuilder().row(0, " b      ");
        assertTrue(gameBuilder.build().isBlocked());
    }

    @Test
    public void givenCoordinatesWithTurnColorWhenCancelThenRemoveThemAndChangeTurn() {
        Game game = new GameBuilder().build();
        List<Coordinate> turnColorCoordinates = new ArrayList<>();
        Color turnColor = game.getTurnColor();
        game.cancel();
        for (int i = 0; i < Coordinate.getDimension(); i++) {
            for (int j = 0; j < Coordinate.getDimension(); j++) {
                if (game.getColor(new Coordinate(i, j)) == turnColor)
                    turnColorCoordinates.add(new Coordinate(i, j));
            }
        }
        assertThat(turnColorCoordinates.size(), is(0));
        assertThat(game.getTurnColor(), is(Color.BLACK));
    }
}
