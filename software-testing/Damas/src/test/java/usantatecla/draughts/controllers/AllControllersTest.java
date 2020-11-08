package usantatecla.draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CancelControllerTest.class,
    ControllerTest.class,
    LogicTest.class,
    MoveControllerTest.class
})
public final class AllControllersTest {
}