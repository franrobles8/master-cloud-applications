package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class GameBuilderTest {
    
    private GameBuilder gameBuilder;

    @Before
    public void before(){
        this.gameBuilder = new GameBuilder();
    }
    
    @Test(expected = AssertionError.class)
    public void givenGameBuilderWhenIncorrectRowNumberThenError() {
        this.gameBuilder.row(8, "        ").build();
    }

    
    @Test(expected = AssertionError.class)
    public void givenGameBuilderWhenIncorrectRowLengthThenError() {
        this.gameBuilder.row(5, "         ").build();
    }

    @Test(expected = AssertionError.class)
    public void givenGameBuilderWhenCharRowLengthThenError() {
        this.gameBuilder.row(5, "    x   ").build();
    }

    @Test
    public void givenGameBuilderWhenCorrectRowsThenOk() {
        Game game = this.gameBuilder.row(5, "    b   ").row(4, "    n   ").build();
        assertNull(game.getColor(new Coordinate(2, 2)));
        assertNull(game.getColor(new Coordinate(7, 7)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(4, 4)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(5, 4)));
    }
}
