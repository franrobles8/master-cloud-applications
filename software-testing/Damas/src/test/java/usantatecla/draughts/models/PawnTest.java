package usantatecla.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;;

public class PawnTest {
    private Pawn whitePawn = new Pawn(Color.WHITE);
    private Pawn blackPawn = new Pawn(Color.BLACK);

    @Before
    public void before() {
        this.whitePawn = new Pawn(Color.WHITE);
        this.blackPawn = new Pawn(Color.BLACK);
    }

    @Test
    public void givenMovementWhenIsBackwardThenReturnsNotAdvancedError() {
        Error error = this.whitePawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(6, 1), new Coordinate(7, 0) });
        assertThat(error, is(Error.NOT_ADVANCED));
    }

    @Test
    public void givenDiagonalDistanceWhenIsBiggerThanTwoThenReturnsTooMuchAdvancedError() {
        Error error = this.whitePawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(4, 3) });
        assertThat(error, is(Error.TOO_MUCH_ADVANCED));
    }

    @Test
    public void givenMaxDiagonalDistanceWhenNotEatenThenReturnsWithoutEatingError() {
        Error error = this.whitePawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 2) });
        assertThat(error, is(Error.WITHOUT_EATING));
    }

    @Test
    public void givenMovementWhenIsCorrectDiagonalThenReturnsNoError() {
        Error error = this.whitePawn.isCorrectDiagonalMovement(1, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 2) });
        assertThat(error, is(nullValue()));
    }

    @Test
    public void givenMovementWhenNotInDiagonalThenReturnsNotDiagonalError() {
        Error error = this.whitePawn.isCorrectMovement(new ArrayList<Piece>(), 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 1) });
        assertThat(error, is(Error.NOT_DIAGONAL));
    }

    @Test
    public void givenSameColorWhenDiagonalEatingThenReturnsColleagueEatingError() {
        List<Piece> diagonalPieces = new ArrayList<>();
        diagonalPieces.add(new Pawn(Color.WHITE));
        Error error = this.whitePawn.isCorrectMovement(diagonalPieces, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(6, 1) });
        assertThat(error, is(Error.COLLEAGUE_EATING));
    }

    @Test
    public void givenCoordinateWhenInLimitRowThenReturnsTrue() {
        assertTrue(this.whitePawn.isLimit(new Coordinate(whiteLimitRow(), 1)));
        assertTrue(this.blackPawn.isLimit(new Coordinate(blackLimitRow(), 0)));
    }

    @Test
    public void givenCoordinateWhenNotInLimitRowThenReturnsFalse() {
        assertFalse(this.whitePawn.isLimit(new Coordinate(whiteLimitRow() + 1, 1)));
        assertFalse(this.blackPawn.isLimit(new Coordinate(blackLimitRow() - 1, 0)));
    }

    @Test
    public void givenBackwardTargetWhenCoordinateIsAdvancedThenReturnsFalse() {
        assertFalse(this.whitePawn.isAdvanced(new Coordinate(6, 1), new Coordinate(7, 0)));
        assertFalse(this.blackPawn.isAdvanced(new Coordinate(1, 0), new Coordinate(0, 1)));
    }

    @Test
    public void givenForwardTargetWhenCoordinateIsAdvancedThenReturnsTrue() {
        assertTrue(this.whitePawn.isAdvanced(new Coordinate(7, 0), new Coordinate(6, 1)));
        assertTrue(this.blackPawn.isAdvanced(new Coordinate(0, 1), new Coordinate(1, 0)));
    }

    private int whiteLimitRow() {
        return 0;
    }

    private int blackLimitRow() {
        return Coordinate.getDimension() - 1;
    }
}
