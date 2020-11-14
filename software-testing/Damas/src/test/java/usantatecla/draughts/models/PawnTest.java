package usantatecla.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class PawnTest {
    private Pawn whitePawn = new Pawn(Color.WHITE);
    private Pawn blackPawn = new Pawn(Color.BLACK);

    @Before
    public void before() {
        this.whitePawn = new Pawn(Color.WHITE);
        this.blackPawn = new Pawn(Color.BLACK);
    }

    private void assertErrorIsCorrectDiagonalMovement(Error expectedError, int amountBetweenDiagonalPieces, int pair,
            Coordinate... coordinates) {
        Error error = this.whitePawn.isCorrectDiagonalMovement(amountBetweenDiagonalPieces, pair, coordinates);
        assertThat(error, is(expectedError));
    }

    private void assertIsCorrectMovement(Error expectedError, List<Piece> diagonalPieces, int pair,
            Coordinate... coordinates) {
        Error error = this.whitePawn.isCorrectMovement(diagonalPieces, pair, coordinates);
        assertThat(error, is(expectedError));
    }

    @Test
    public void givenMovementWhenIsBackwardThenReturnsNotAdvancedError() {
        this.assertErrorIsCorrectDiagonalMovement(Error.NOT_ADVANCED, 0, 0, new Coordinate(6, 1), new Coordinate(7, 0));
    }

    @Test
    public void givenDiagonalDistanceWhenIsBiggerThanTwoThenReturnsTooMuchAdvancedError() {
        this.assertErrorIsCorrectDiagonalMovement(Error.TOO_MUCH_ADVANCED, 0, 0, new Coordinate(7, 0),
                new Coordinate(4, 3));
    }

    @Test
    public void givenMaxDiagonalDistanceWhenNotEatenThenReturnsWithoutEatingError() {
        this.assertErrorIsCorrectDiagonalMovement(Error.WITHOUT_EATING, 0, 0, new Coordinate(7, 0),
                new Coordinate(5, 2));
    }

    @Test
    public void givenMovementWhenIsCorrectDiagonalThenReturnsNoError() {
        this.assertErrorIsCorrectDiagonalMovement(null, 1, 0, new Coordinate(7, 0), new Coordinate(5, 2));
    }

    @Test
    public void givenMovementWhenNotInDiagonalThenReturnsNotDiagonalError() {
        this.assertIsCorrectMovement(Error.NOT_DIAGONAL, new ArrayList<Piece>(), 0, new Coordinate(7, 0),
                new Coordinate(5, 1));
    }

    @Test
    public void givenSameColorWhenDiagonalEatingThenReturnsColleagueEatingError() {
        this.assertIsCorrectMovement(Error.COLLEAGUE_EATING, Arrays.asList(new Pawn(Color.WHITE)), 0,
                new Coordinate(7, 0), new Coordinate(6, 1));
    }

    @Test
    public void givenCoordinateWhenInLimitRowThenReturnsTrue() {
        assertTrue(this.whitePawn.isLimit(new Coordinate(whiteLimitRow(), 1)));
        assertTrue(this.blackPawn.isLimit(new Coordinate(blackLimitRow(), 0)));
    }

    @Test
    public void givenCoordinateWhenNotInLimitRowThenReturnsFalse() {
        assertFalse(this.whitePawn.isLimit(new Coordinate(whiteLimitRow() + moveWhiteForward(1), 1)));
        assertFalse(this.blackPawn.isLimit(new Coordinate(blackLimitRow() + moveBlackForward(1), 0)));
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

    private int moveBlackForward(int nRows) {
        return nRows;
    }

    private int moveWhiteForward(int nRows) {
        return -nRows;
    }
}
