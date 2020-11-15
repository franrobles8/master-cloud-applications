package usantatecla.draughts.models;

import usantatecla.draughts.models.builders.game.GameBuilderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CoordinateTest.class,
    CorrectDraughtTest.class,
    DirectionTest.class,
    GameBuilderTest.class,
    GameTest.class,
    IncorrectDraughtTest.class,
    InitialGameTest.class,
    PawnTest.class,
    StateTest.class,
    TurnTest.class
})
public final class AllModelTests {
}