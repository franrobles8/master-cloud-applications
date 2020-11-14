package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.builders.game.GameMother;

public class IncorrectDraughtTest extends DraughtTest {

    @Before
    public void setUp(){
        this.gameMother = new GameMother();
    }



    private void assertErrorMove(Error error, Coordinate... coordinates) {
        assertEquals(error, this.game.move(coordinates));
        assertEquals(this.expectedGame, this.game);
    }

    @Test
    public void moveWithBlackMovementThenOppositePieceError() {
        this.game = this.gameMother.blackRowWithWrongTurn(1, " N      ");
        this.expectedGame = this.gameMother.blackRowWithChangeTurn(1, " N      ");
        this.assertErrorMove(Error.OPPOSITE_PIECE,
            new Coordinate(1, 1),
            new Coordinate(2, 0) 
            
        );
    }


    @Test
    public void moveWithWhiteMovementThenOppositePieceError() {
        this.game = this.gameMother.whiteRowWithWrongTurn(2, "B       ");
        this.expectedGame = this.gameMother.whiteRowWithChangeTurn(2, "B       ");
        this.assertErrorMove(Error.OPPOSITE_PIECE,
            new Coordinate(2, 0),
            new Coordinate(1, 1) 
            
        );
    }

    @Test
    public void moveWithWhiteThenNotDiagonalError() {
        this.game = this.gameMother.whiteRowWithTurn(4, "     B  ");
        this.expectedGame = this.game;

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(3, 5) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(5, 5) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(4, 6) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(4, 4) 
            
        );


    }

    @Test
    public void moveWithBlackThenNotDiagonalError() {
        this.game = this.gameMother.blackRowWithTurn(4, "     N  ");
        this.expectedGame = this.game;

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(3, 5) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(5, 5) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(4, 6) 
            
        );

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 5),
            new Coordinate(4, 4) 
            
        );
    }

    @Test
    public void moveWithBlackMovementThenNotEmptyTargetError() {
        Pair<Integer,String> rowGame = Pair.of (1, " N      ");
        Pair<Integer,String> rowGame2 = Pair.of(2, "  n     ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2);
        this.expectedGame = this.game;
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(1, 1),
            new Coordinate(2, 2) 
            
        );
    }

    @Test
    public void moveWithWhiteMovementThenNotEmptyTargetError() {
        Pair<Integer,String> rowGame = Pair.of (2, " B      ");
        Pair<Integer,String> rowGame2 = Pair.of(1, "  b     ");
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2);
        this.expectedGame = this.game;
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(2, 1),
            new Coordinate(1, 2) 
            
        );
    }

    @Test
    public void moveWithBlackMovementWhenEatingThenNotEmptyTargetError() {
        Pair<Integer,String> rowGame = Pair.of (1, " N      ");
        Pair<Integer,String> rowGame2 = Pair.of(2, "  b     ");
        Pair<Integer,String> rowGame3 = Pair.of(3, "   b    ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2, rowGame3);
        this.expectedGame = this.game;
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(1, 1),
            new Coordinate(3, 3) 
            
        );
    }

    @Test
    public void moveWithWhiteMovementWhenEatingThenNotEmptyTargetError() {
        Pair<Integer,String> rowGame = Pair.of(3, " B      ");
        Pair<Integer,String> rowGame2 = Pair.of(2, "  N     ");
        Pair<Integer,String> rowGame3 = Pair.of(1, "   n    ");
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2, rowGame3);
        this.expectedGame = this.game;
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(3, 1),
            new Coordinate(1, 3) 
            
        );
    }

    @Test
    public void secondMoveWithWhiteEatingThenNotDiagonalError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  B     ");
        Pair<Integer,String> rowGame2= Pair.of(4, "   n    ");
       
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(2, 4) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(4, 4) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(3, 5) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(3, 3) 
        );
    }

    @Test
    public void secondMoveWithBlackEatingThenNotDiagonalError() {
        Pair<Integer,String> rowGame = Pair.of(4, "  N     ");
        Pair<Integer,String> rowGame2= Pair.of(5, "   b    ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2);
        this.expectedGame = this.game;    

        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 2),
            new Coordinate(6, 4),
            new Coordinate(5, 4) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 2),
            new Coordinate(6, 4),
            new Coordinate(7, 4) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 2),
            new Coordinate(6, 4),
            new Coordinate(6, 5) 
        );
        this.assertErrorMove( Error.NOT_DIAGONAL,
            new Coordinate(4, 2),
            new Coordinate(6, 4),
            new Coordinate(6, 3) 
        );
    }

    @Test
    public void moveWithWhiteEatingThenColleagueEatingError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  B     ");
        Pair<Integer,String> rowGame2= Pair.of(4, "   b    ");
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.COLLEAGUE_EATING,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenColleagueEatingError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  N     ");
        Pair<Integer,String> rowGame2= Pair.of(4, "   n    ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2);
        this.expectedGame = this.game;
        

        this.assertErrorMove( Error.COLLEAGUE_EATING,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenTooMuchEatingsError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  N     ");
        Pair<Integer,String> rowGame2= Pair.of(4, "   b    ");
        Pair<Integer,String> rowGame3= Pair.of(2, "     b  ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2, rowGame3);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithWhiteEatingThenTooMuchEatingsError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  B     ");
        Pair<Integer,String> rowGame2= Pair.of(4, "   n    ");
        Pair<Integer,String> rowGame3= Pair.of(2, "     n  ");
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2, rowGame3);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithWhiteThenTooMuchJumpsError() {
        this.game = this.gameMother.whiteRowWithTurn(5, "  B     ");
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(4, 3),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackThenTooMuchJumpsError() {
        this.game = this.gameMother.blackRowWithTurn(5, "  N     ");
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(4, 3),
            new Coordinate(0, 7)
        );
    }
    
    @Test
    public void moveWithWhiteEatingThenTooMuchJumpsError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  B     ");
        Pair<Integer,String> rowGame2 = Pair.of(4, "   n    ");
        this.game = this.gameMother.rowsWithWhiteTurn(rowGame, rowGame2);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenTooMuchJumpsError() {
        Pair<Integer,String> rowGame = Pair.of(5, "  N     ");
        Pair<Integer,String> rowGame2 = Pair.of(4, "   b    ");
        this.game = this.gameMother.rowsWithBlackTurn(rowGame, rowGame2);
        this.expectedGame = this.game;

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(0, 7)
        );
    }


}
