package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.tictactoe.controllers.Logic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ConsoleViewTest {
    @Mock
    private StartView startView;

    @Mock
    private PlayView playView;

    @InjectMocks
    private ConsoleView consoleView = new ConsoleView(new Logic());

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenConsoleViewTestWhenStartThenInteractsWithStartView() {
        consoleView.start();
        verify(startView, times(1)).interact();
    }

    @Test
    public void givenConsoleViewTestWhenPlayThenInteractsWithPlayView() {
        consoleView.play();
        verify(playView, times(1)).interact();
    }
}
