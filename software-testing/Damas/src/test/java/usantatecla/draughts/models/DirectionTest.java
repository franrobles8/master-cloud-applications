package usantatecla.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DirectionTest {
    
    @Test
    public void givenDirectionAndCoordinateWhenSameDirectionThenTrue(){
        assertTrue(Direction.NE.isOnDirection(new Coordinate(7,7)));
        assertTrue(Direction.SE.isOnDirection(new Coordinate(-2,2)));
        assertTrue(Direction.SW.isOnDirection(new Coordinate(-2,-2)));
        assertTrue(Direction.NW.isOnDirection(new Coordinate(5,-5)));
    }

    @Test
    public void givenDirectionAndCoordinateWhenSameDirectionThenFalse(){
        assertFalse(Direction.NE.isOnDirection(new Coordinate(6,7)));
        assertFalse(Direction.SE.isOnDirection(new Coordinate(0,2)));
        assertFalse(Direction.SW.isOnDirection(new Coordinate(0,-2)));
        assertFalse(Direction.NW.isOnDirection(new Coordinate(7,7)));
    }

}
