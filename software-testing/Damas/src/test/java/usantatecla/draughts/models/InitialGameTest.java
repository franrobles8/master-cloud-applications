package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import usantatecla.draughts.models.builders.game.GameMother;

public class InitialGameTest extends DraughtTest {
    
    @Before
    public void setUp(){
        this.gameMother = new GameMother();
    }
    
    @Test
    public void givenGameWhenIsNewThenFirstLocations() {
        this.game = new Game();
        
        this.expectedGame = this.gameMother.initial();
        assertEquals(this.expectedGame, this.game);
    }

    @Test
    public void givenGameWhenCancelThenNoWhitePieces() {
        this.game = new Game();
        this.game.cancel();
        this.expectedGame = this.gameMother.canceledGame();
        assertEquals(this.expectedGame, this.game);
    }

    @Test
    public void givenGameWhenResetThenFirstLocations() {
        this.game = new Game();
        this.game.move(
            new Coordinate(5, 6),
            new Coordinate(4, 7));
        this.game.reset();
        this.expectedGame = this.gameMother.initial();
        assertEquals(this.expectedGame, this.game);
    }


}
