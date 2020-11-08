package usantatecla.draughts.controllers;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class LogicTest {
    @Test
    public void givenStateReturnSpecificController() {
        Logic logic = new Logic();
        assertThat(logic.getController(), instanceOf(StartController.class));
        logic.getController().state.next();
        assertThat(logic.getController(), instanceOf(PlayController.class));
        logic.getController().state.next();
        assertThat(logic.getController(), instanceOf(ResumeController.class));
        logic.getController().state.next();
        assertThat(logic.getController(), is(nullValue()));
    }
}
