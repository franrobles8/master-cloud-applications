package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void givenTwoCoordinatesWhenIsDiagonalThenTrue() {
        assertTrue(new Coordinate(0,0).isOnDiagonal(new Coordinate(1,1)));
        assertTrue(new Coordinate(0,0).isOnDiagonal(new Coordinate(7,7)));
        assertTrue(new Coordinate(4,3).isOnDiagonal(new Coordinate(5,4)));
        assertTrue(new Coordinate(4,3).isOnDiagonal(new Coordinate(5,2)));
        assertTrue(new Coordinate(4,3).isOnDiagonal(new Coordinate(3,4)));
        assertTrue(new Coordinate(4,3).isOnDiagonal(new Coordinate(3,2)));
    }

    @Test
    public void givenTwoCoordinatesWhenIsDiagonalThenFalse(){
        assertFalse(new Coordinate(5,2).isOnDiagonal(new Coordinate(5,2)));
        assertFalse(new Coordinate(5,2).isOnDiagonal(new Coordinate(5,1)));
        assertFalse(new Coordinate(5,2).isOnDiagonal(new Coordinate(5,3)));
        assertFalse(new Coordinate(5,2).isOnDiagonal(new Coordinate(6,2)));
        assertFalse(new Coordinate(5,2).isOnDiagonal(new Coordinate(4,2)));
    }

    @Test
    public void givenCoordinateWhenGetDirectionThenDirection() {
        assertEquals(null, new Coordinate(5,5).getDirection(new Coordinate(3,0)));
        assertEquals(Direction.NE, new Coordinate(5,5).getDirection(new Coordinate(6,6)));
        assertEquals(Direction.SE, new Coordinate(5,5).getDirection(new Coordinate(4,6)));
        assertEquals(Direction.SW, new Coordinate(5,5).getDirection(new Coordinate(4,4)));
        assertEquals(Direction.NW, new Coordinate(5,5).getDirection(new Coordinate(6,4)));
    }

    @Test
    public void givenTwoCoordinatesWhenGetBetweenDiagonalCoordinateThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).getBetweenDiagonalCoordinate(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).getBetweenDiagonalCoordinate(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).getBetweenDiagonalCoordinate(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).getBetweenDiagonalCoordinate(new Coordinate(0, 4)));
    }


}