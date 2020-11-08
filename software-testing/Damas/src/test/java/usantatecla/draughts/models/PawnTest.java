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
    private Pawn pawn;

    @Before
    public void before() {
        pawn = new Pawn(Color.WHITE);
    }

    @Test
    public void givenInvalidBackwardMovementReturnsNotAdvancedError() {
        Error error = pawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(6, 1), new Coordinate(7, 0) });
        assertThat(error, is(Error.NOT_ADVANCED));
    }

    @Test
    public void givenDiagonalDistanceBiggerThanTwoReturnsTooMuchAdvancedError() {
        Error error = pawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(4, 3) });
        assertThat(error, is(Error.TOO_MUCH_ADVANCED));
    }

    @Test
    public void givenMaxDiagonalDistanceButNoEatReturnsWithoutEatingError() {
        Error error = pawn.isCorrectDiagonalMovement(0, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 2) });
        assertThat(error, is(Error.WITHOUT_EATING));
    }

    @Test
    public void givenCorrectDiagonalMovementReturnsNoError() {
        Error error = pawn.isCorrectDiagonalMovement(1, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 2) });
        assertThat(error, is(nullValue()));
    }

    @Test
    public void givenMovementNotInDiagonalReturnsNotDiagonalError() {
        Error error = pawn.isCorrectMovement(new ArrayList<Piece>(), 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(5, 1) });
        assertThat(error, is(Error.NOT_DIAGONAL));
    }

    @Test
    public void givenSameColorDiagonalEatingReturnsColleagueEatingError() {
        List<Piece> diagonalPieces = new ArrayList<>();
        diagonalPieces.add(new Pawn(Color.WHITE));
        Error error = pawn.isCorrectMovement(diagonalPieces, 0,
                new Coordinate[] { new Coordinate(7, 0), new Coordinate(6, 1) });
        assertThat(error, is(Error.COLLEAGUE_EATING));
    }

    @Test
    public void givenCoordinateInLimitRowReturnsTrue() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);
        assertTrue(whitePawn.isLimit(new Coordinate(whiteLimitRow(), 1)));
        assertTrue(blackPawn.isLimit(new Coordinate(blackLimitRow(), 0)));
    }

    @Test
    public void givenCoordinateNotInLimitRowReturnsFalse() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);
        assertFalse(whitePawn.isLimit(new Coordinate(whiteLimitRow() + 1, 1)));
        assertFalse(blackPawn.isLimit(new Coordinate(blackLimitRow() - 1, 0)));
    }

    @Test
    public void givenBackwardTargetCoordinateIsAdvancedReturnsFalse() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);
        assertFalse(whitePawn.isAdvanced(new Coordinate(6, 1), new Coordinate(7, 0)));
        assertFalse(blackPawn.isAdvanced(new Coordinate(1, 0), new Coordinate(0, 1)));
    }

    @Test
    public void givenForwardTargetCoordinateIsAdvancedReturnsTrue() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);
        assertTrue(whitePawn.isAdvanced(new Coordinate(7, 0), new Coordinate(6, 1)));
        assertTrue(blackPawn.isAdvanced(new Coordinate(0, 1), new Coordinate(1, 0)));
    }

    private int whiteLimitRow() {
        return 0;
    }

    private int blackLimitRow() {
        return Coordinate.getDimension() - 1;
    }
}
