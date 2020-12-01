package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LogicTest {
    
    private Logic logic;
	
	@BeforeEach
	public void setup() {
		logic = new Logic();
	}
	
	@Test
	void testGivenNewLogicWhenGetControllerThenController() {
		assertThat(this.logic.getController(), is(Controller.class));
	}
	
	@Test
	void testGivenNewLogicWhenGetControllerThenNotNull() {
		assertNotNull(this.logic.getController());
	}
}
