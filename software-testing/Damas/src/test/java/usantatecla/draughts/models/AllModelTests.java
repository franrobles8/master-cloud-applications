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
    TurnTest.class,
    IncorrectDraughtTest.class,
    CorrectDraughtTest.class,
    GameBuilderTest.class
})
public final class AllModelTests {
}