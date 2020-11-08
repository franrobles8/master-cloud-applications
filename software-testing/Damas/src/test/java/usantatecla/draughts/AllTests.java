package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import usantatecla.draughts.controllers.AllControllersTest;
//import usantatecla.draughts.controllers.AllControllerTest;
import usantatecla.draughts.models.AllModelTests;
//import usantatecla.draughts.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllModelTests.class,
    AllControllersTest.class
})
public final class AllTests {
}