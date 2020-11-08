package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CoordinateTest.class,
    DirectionTest.class,
    DraughtTest.class,
    GameTest.class,
    PawnTest.class,
    StateTest.class,
    TurnTest.class
    // PieceTest.class,
    // GameBuilderTest.class,
    // InitialGameTest.class,
    // IncorrectMovesPawnGameTest.class,
    // CorrectMovesPawnGameTest.class,
    // IncorrectMovesDraughtGameTest.class,
    // CorrectMovesDraughtGameTest.class,
    // IsBlockedGameTest.class } )
})
public final class AllModelTests {
}