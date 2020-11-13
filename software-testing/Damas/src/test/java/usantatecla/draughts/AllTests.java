package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import usantatecla.draughts.controllers.AllControllersTest;
import usantatecla.draughts.models.AllModelTests;
import usantatecla.draughts.views.AllViewsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllModelTests.class,
    AllControllersTest.class,
    AllViewsTest.class
})
public final class AllTests {
}