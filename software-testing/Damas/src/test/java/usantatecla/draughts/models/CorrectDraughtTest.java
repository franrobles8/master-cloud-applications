package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import usantatecla.draughts.models.builders.game.GameBuilder;
import usantatecla.draughts.models.builders.game.GameMother;

public class CorrectDraughtTest extends GameTest {


    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }

    @Before
    public void setUp(){
        gameMother = new GameMother();
    }

    @Test
    public void moveWithBlackMovement() {
        
        this.game = this.gameMother.blackRowWithTurn(4, "      N ");
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(5, "     N  ");
        this.assertMove(
            new Coordinate(5, 5),
            new Coordinate(4, 6)     
        );
    }

    @Test
    public void moveWithWhiteMovement() {
        
        this.game = this.gameMother.blackRowWithTurn(4, "     B  ");
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(5, "      B ");
        this.assertMove(
            new Coordinate(4, 5),
            new Coordinate(5, 6) 
            
        );
    }

    @Test
    public void moveWithWhiteEating() {

        Pair<Integer,String> blackRow = Pair.of(4, "       B");
        Pair<Integer,String> whiteRow = Pair.of(5, "      N ");
        this.game = this.gameMother.whiteEating(whiteRow,blackRow);
        this.expectedGame = this.gameMother.whiteRowWithChangeTurn(6, "     B  ");
        
        this.assertMove(
            new Coordinate(4, 7), 
            new Coordinate(6, 5)
        );
    }

    @Test
    public void moveWithBlackEating() {
        Pair<Integer,String> blackRow = Pair.of(4, "     N  ");
        Pair<Integer,String> whiteRow = Pair.of(5, "      B ");
        this.game = this.gameMother.blackEating(whiteRow,blackRow);
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(6, "       N");
        this.assertMove(
            new Coordinate(4, 5), 
            new Coordinate(6, 7)
        );
    }

    @Test
    public void moveWithWhiteDoubleEating() {
        Pair<Integer,String> whiteRow = Pair.of(5, "       B");
        Pair<Integer,String> blackRow = Pair.of(4, "      N ");
        Pair<Integer,String> blackRow2 = Pair.of(2, "    N   ");

        this.game = this.gameMother.whiteEating(whiteRow,blackRow, blackRow2);
        this.expectedGame = this.expectedGame = this.gameMother.whiteRowWithChangeTurn(1, "   B    ");
        
        this.assertMove(
            new Coordinate(5, 7),
            new Coordinate(3, 5),
            new Coordinate(1, 3)
        );
    }

    @Test
    public void moveWithBlackDoubleEating() {
        Pair<Integer,String> whiteRow = Pair.of(1, "       N");
        Pair<Integer,String> blackRow = Pair.of(2, "      B ");
        Pair<Integer,String> blackRow2 = Pair.of(4, "    B   ");
        
        this.game = this.gameMother.blackEating(whiteRow,blackRow, blackRow2);
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(5, "   N    ");
        this.assertMove(
            new Coordinate(1, 7), 
            new Coordinate(3, 5),
            new Coordinate(5, 3)
        );
    }

    @Test
    public void moveWithBlackQueenDoubleEating() {
        Pair<Integer,String> blackRow = Pair.of(5, "     N  ");
        Pair<Integer,String> whiteRow = Pair.of(4, "      B ");
        Pair<Integer,String> whiteRow2 = Pair.of(2, "      B ");
        
        this.game = this.gameMother.blackEating(blackRow, whiteRow, whiteRow2);
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(0, "    N   ");
        this.assertMove(
            new Coordinate(5, 5), 
            new Coordinate(3, 7),
            new Coordinate(0, 4)
        );
    }

    @Test
    public void moveWithWhiteQueenDoubleEating() {
        Pair<Integer,String> whiteRow = Pair.of(0, "     B  ");
        Pair<Integer,String> blackRow = Pair.of(1, "      N ");
        Pair<Integer,String> blackRow2 = Pair.of(3, "      N ");

        this.game = this.gameMother.whiteEating(whiteRow,blackRow, blackRow2);
        this.expectedGame = this.gameMother.whiteRowWithChangeTurn(7, "  B     ");
        this.assertMove(
            new Coordinate(0, 5), 
            new Coordinate(2, 7),
            new Coordinate(7, 2)
        );
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

}
