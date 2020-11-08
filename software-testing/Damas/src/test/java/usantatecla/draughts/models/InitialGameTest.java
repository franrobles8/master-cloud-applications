package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class InitialGameTest extends DraughtTest {
    
    @Test
    public void givenGameWhenIsNewThenFirstLocations() {
        this.game = new Game();
        
        Entry<Integer,String> firstRowBlack = new AbstractMap.SimpleEntry<> (0, " n n n n");
        Entry<Integer,String> secondRowBlack = new AbstractMap.SimpleEntry<>(1, "n n n n ");
        Entry<Integer,String> thirdRowBlack = new AbstractMap.SimpleEntry<> (2, " n n n n");
        Entry<Integer,String> firstRowWhite = new AbstractMap.SimpleEntry<> (5, "b b b b ");
        Entry<Integer,String> secondRowWhite = new AbstractMap.SimpleEntry<>(6, " b b b b");
        Entry<Integer,String> thirdRowWhite = new AbstractMap.SimpleEntry<> (7, "b b b b ");

        this.setExpectedGame(Color.WHITE,
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(
                    firstRowBlack,
                    secondRowBlack, 
                    thirdRowBlack,
                    firstRowWhite,
                    secondRowWhite, 
                    thirdRowWhite))
            )
        );
        assertEquals(this.expectedGame, this.game);
    }

    @Test
    public void givenGameWhenCancelThenNoWhitePieces() {
        this.game = new Game();
        this.game.cancel();

        Entry<Integer,String> firstRowBlack = new AbstractMap.SimpleEntry<> (0, " n n n n");
        Entry<Integer,String> secondRowBlack = new AbstractMap.SimpleEntry<>(1, "n n n n ");
        Entry<Integer,String> thirdRowBlack = new AbstractMap.SimpleEntry<> (2, " n n n n");
        
        this.setExpectedGame(Color.BLACK,
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(
                    firstRowBlack,
                    secondRowBlack, 
                    thirdRowBlack))
            )
        );
        assertEquals(this.expectedGame, this.game);
    }

    @Test
    public void givenGameWhenResetThenFirstLocations() {
        this.game = new Game();
        this.game.move(
            new Coordinate(5, 6),
            new Coordinate(4, 7));
        this.game.reset();

        Entry<Integer,String> firstRowBlack = new AbstractMap.SimpleEntry<> (0, " n n n n");
        Entry<Integer,String> secondRowBlack = new AbstractMap.SimpleEntry<>(1, "n n n n ");
        Entry<Integer,String> thirdRowBlack = new AbstractMap.SimpleEntry<> (2, " n n n n");
        Entry<Integer,String> firstRowWhite = new AbstractMap.SimpleEntry<> (5, "b b b b ");
        Entry<Integer,String> secondRowWhite = new AbstractMap.SimpleEntry<>(6, " b b b b");
        Entry<Integer,String> thirdRowWhite = new AbstractMap.SimpleEntry<> (7, "b b b b ");

        this.setExpectedGame(Color.WHITE,
            this.getDraughtGame(
                new ArrayList<Entry<Integer,String>>(List.of(
                    firstRowBlack,
                    secondRowBlack, 
                    thirdRowBlack,
                    firstRowWhite,
                    secondRowWhite, 
                    thirdRowWhite))
            )
        );
        assertEquals(this.expectedGame, this.game);
    }


}
