package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ConsoleViewTest {
    @Mock
    private View view;

    @Mock
    private StartController startController;

    @Mock
    private PlayController playController;

    @Mock
    private ResumeController resumeController;

    @InjectMocks
    private ConsoleView consoleView = new ConsoleView();

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenConsoleViewTestWhenStartThenInteractsWithStartController() {
        this.consoleView.interact(this.startController);
        verify(startController, times(1)).accept(this.view);
    }

    @Test
    public void givenConsoleViewTestWhenPlayThenInteractsWithPlayController() {
        this.consoleView.interact(this.playController);
        verify(playController, times(1)).accept(this.view);
    }

    @Test
    public void givenConsoleViewTestWhenIsResumedThenInteractsWithResumeController() {
        this.consoleView.interact(this.resumeController);
        verify(resumeController, times(1)).accept(this.view);
    }

}
