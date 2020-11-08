package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import org.junit.Test;

public class IncorrectDraughtTest extends DraughtTest {
    
    private Map<Integer,String> rows; 
    private Color color;

    @Override
    protected void setGame(Color color, Map<Integer,String> rows) {
        this.color = color;
        this.rows = rows;
        super.setGame(color, rows);
    }

    private void assertErrorMove(Error error, Coordinate... coordinates) {
        assertEquals(error, this.game.move(coordinates));
        assertEquals(new GameBuilder().rows(this.rows.entrySet()).color(this.color).build(), this.game);
    }

    @Test
    public void moveWithBlackMovementThenOppositePieceError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(1, " N      ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );
        this.assertErrorMove(Error.OPPOSITE_PIECE,
            new Coordinate(1, 1),
            new Coordinate(2, 0) 
            
        );
    }

    @Test
    public void moveWithWhiteMovementThenOppositePieceError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(2, "B       ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );
        this.assertErrorMove(Error.OPPOSITE_PIECE,
            new Coordinate(2, 0),
            new Coordinate(1, 1) 
            
        );
    }

    @Test
    public void moveWithWhiteThenNotDiagonalError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(4, "     B  ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );

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
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(4, "     N  ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );

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
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<> (1, " N      ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(2, "  n     ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(1, 1),
            new Coordinate(2, 2) 
            
        );
    }

    @Test
    public void moveWithWhiteMovementThenNotEmptyTargetError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<> (2, " B     ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(1, "  b     ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(2, 1),
            new Coordinate(1, 2) 
            
        );
    }

    @Test
    public void moveWithBlackMovementWhenEatingThenNotEmptyTargetError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<> (1, " N      ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(2, "  b     ");
        Entry<Integer,String> rowGame3 = new AbstractMap.SimpleEntry<>(3, "   b    ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2,rowGame3))
            )
        );
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(1, 1),
            new Coordinate(3, 3) 
            
        );
    }

    @Test
    public void moveWithWhiteMovementWhenEatingThenNotEmptyTargetError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<> (3, " B      ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(2, "  N     ");
        Entry<Integer,String> rowGame3 = new AbstractMap.SimpleEntry<>(1, "   n    ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2,rowGame3))
            )
        );
        this.assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(3, 1),
            new Coordinate(1, 3) 
            
        );
    }

    @Test
    public void secondMoveWithWhiteEatingThenNotDiagonalError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  B     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(4, "   n    ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );

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
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(4, "  N     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(5, "   b    ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );

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
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  B     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(4, "   b    ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );

        this.assertErrorMove( Error.COLLEAGUE_EATING,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenColleagueEatingError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  N     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(4, "   n    ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2))
            )
        );

        this.assertErrorMove( Error.COLLEAGUE_EATING,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenTooMuchEatingsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  N     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(4, "   b    ");
        Entry<Integer,String> rowGame3= new AbstractMap.SimpleEntry<>(2, "     b  ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2,rowGame3))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithWhiteEatingThenTooMuchEatingsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  B     ");
        Entry<Integer,String> rowGame2= new AbstractMap.SimpleEntry<>(4, "   n    ");
        Entry<Integer,String> rowGame3= new AbstractMap.SimpleEntry<>(2, "     n  ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame,rowGame2,rowGame3))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 2),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithWhiteThenTooMuchJumpsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  B     ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(4, 3),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackThenTooMuchJumpsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  N     ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(4, 3),
            new Coordinate(0, 7)
        );
    }
    
    @Test
    public void moveWithWhiteEatingThenTooMuchJumpsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<> (5, "  B     ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(4, "   n    ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame, rowGame2))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(0, 7)
        );
    }

    @Test
    public void moveWithBlackEatingThenTooMuchJumpsError() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "  N     ");
        Entry<Integer,String> rowGame2 = new AbstractMap.SimpleEntry<>(4, "   b    ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame, rowGame2))
            )
        );

        this.assertErrorMove( Error.TOO_MUCH_JUMPS,
            new Coordinate(5, 2),
            new Coordinate(3, 4),
            new Coordinate(0, 7)
        );
    }


}
