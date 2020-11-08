package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void givenTwoCoordinatesWhenGetBetweenDiagonalCoordinateThenSuccessfull() {
        
        assertEquals(new Coordinate(4, 3), new Coordinate(5, 2).getBetweenDiagonalCoordinate(new Coordinate(3, 4)));
        assertEquals(new Coordinate(4, 1), new Coordinate(5, 2).getBetweenDiagonalCoordinate(new Coordinate(3, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(5, 2).getBetweenDiagonalCoordinate(new Coordinate(7, 0)));
        assertEquals(new Coordinate(1, 3), new Coordinate(5, 2).getBetweenDiagonalCoordinate(new Coordinate(7, 4)));
    }

    @Test
    public void givenTwoCoordinatesWhenGetDiagonalDistanceThenResult() {
        assertEquals(7, new Coordinate(0, 0).getDiagonalDistance(new Coordinate(7, 7)));
        assertEquals(5, new Coordinate(0, 7).getDiagonalDistance(new Coordinate(-5, 2)));
    }

    @Test
    public void givenCoordinateWhenGetDiagonalCoordinatesWithOneDistanceThenEquals(){
        Coordinate coordinate = new Coordinate(1,5);
        List<Coordinate> diagonalCoordinates = Arrays.asList(new Coordinate[]{
            new Coordinate(2,6),
            new Coordinate(0,6),
            new Coordinate(0,4),
            new Coordinate(2,4)
        });

        assertEquals(diagonalCoordinates, coordinate.getDiagonalCoordinates(1));
    }

    @Test
    public void givenCoordinateWhenGetDiagonalCoordinatesWithTwoDistanceThenEquals(){
        Coordinate coordinate = new Coordinate(1,5);
        List<Coordinate> diagonalCoordinates = Arrays.asList(new Coordinate[]{
            new Coordinate(3,7),
            new Coordinate(3,3),
        });
        assertEquals(diagonalCoordinates, coordinate.getDiagonalCoordinates(2));
    }

    @Test
    public void givenCoordinateWhenGetDiagonalCoordinatesThenEmpty(){
        Coordinate coordinateOrigin = new Coordinate(0,0);
        Coordinate coordinateTarget = new Coordinate(1,1);
        assertEquals(new ArrayList<Coordinate>(), coordinateOrigin.getBetweenDiagonalCoordinates(coordinateTarget));
    }

    @Test
    public void testGivenCoordinateWhenGetDiagonalCoordinatesThenNotEmpty(){
        Coordinate coordinateOrigin = new Coordinate(7,7);
        Coordinate coordinateTarget = new Coordinate(5,5);
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(6,6));
        assertEquals(coordinates, coordinateOrigin.getBetweenDiagonalCoordinates(coordinateTarget));
    }


}