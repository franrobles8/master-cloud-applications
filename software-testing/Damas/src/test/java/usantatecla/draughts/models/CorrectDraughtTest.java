package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class CorrectDraughtTest extends DraughtTest {

    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }

    @Test
    public void moveWithBlackMovement() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(5, "     N  ");
        Entry<Integer,String> rowGameExpected = new AbstractMap.SimpleEntry<>(4, "      N ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );
        this.setExpectedGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGameExpected)) 
            )
        );
        this.assertMove(
            new Coordinate(5, 5),
            new Coordinate(4, 6) 
            
        );
    }

    @Test
    public void moveWithWhiteMovement() {
        Entry<Integer,String> rowGame = new AbstractMap.SimpleEntry<>(4, "     B  ");
        Entry<Integer,String> rowGameExpected = new AbstractMap.SimpleEntry<>(5, "      B ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGame))
            )
        );
        this.setExpectedGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowGameExpected)) 
            )
        );
        this.assertMove(
            new Coordinate(4, 5),
            new Coordinate(5, 6) 
            
        );
    }

    @Test
    public void moveWithWhiteEating() {
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (4, "       B");
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (5, "      N ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(6, "     B  ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow,whiteRow))
            )
        );
        this.setExpectedGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(4, 7), 
            new Coordinate(6, 5)
        );
    }

    @Test
    public void moveWithBlackEating() {
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (4, "     N  ");
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (5, "      B ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(6, "       N");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow,whiteRow))
            )
        );
        this.setExpectedGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(4, 5), 
            new Coordinate(6, 7)
        );
    }

    @Test
    public void moveWithWhiteDoubleEating() {
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (5, "       B");
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (4, "      N ");
        Entry<Integer,String> blackRow2 = new AbstractMap.SimpleEntry<>  (2, "    N   ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(1, "   B    ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow,blackRow2,whiteRow))
            )
        );
        this.setExpectedGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(5, 7),
            new Coordinate(3, 5),
            new Coordinate(1, 3)
        );
    }

    @Test
    public void moveWithBlackDoubleEating() {
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (1, "       N");
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (2, "      B ");
        Entry<Integer,String> blackRow2 = new AbstractMap.SimpleEntry<>  (4, "    B   ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(5, "   N    ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow, blackRow2, whiteRow))
            )
        );
        this.setExpectedGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(1, 7), 
            new Coordinate(3, 5),
            new Coordinate(5, 3)
        );
    }

    @Test
    public void moveWithBlackQueenDoubleEating() {
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (5, "     N  ");
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (4, "      B ");
        Entry<Integer,String> whiteRow2 = new AbstractMap.SimpleEntry<>  (2, "      B ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(0, "    N   ");
        this.setGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow, whiteRow2, whiteRow))
            )
        );
        this.setExpectedGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(5, 5), 
            new Coordinate(3, 7),
            new Coordinate(0, 4)
        );
    }

    @Test
    public void moveWithWhiteQueenDoubleEating() {
        Entry<Integer,String> whiteRow = new AbstractMap.SimpleEntry<>   (0, "     B  ");
        Entry<Integer,String> blackRow = new AbstractMap.SimpleEntry<>   (1, "      N ");
        Entry<Integer,String> blackRow2 = new AbstractMap.SimpleEntry<>  (3, "      N ");
        Entry<Integer,String> rowExpected = new AbstractMap.SimpleEntry<>(7, "  B     ");
        this.setGame(
            Color.WHITE, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(blackRow, blackRow2, whiteRow))
            )
        );
        this.setExpectedGame(
            Color.BLACK, 
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(rowExpected))
            )
        );
        this.assertMove(
            new Coordinate(0, 5), 
            new Coordinate(2, 7),
            new Coordinate(7, 2)
        );
    }


}
