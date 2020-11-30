package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ConsoleViewTest {
    @Mock
    private StartView startView;

    @InjectMocks
    private ConsoleView consoleView;

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenConsoleViewTestWhenStartThenInteractsWithStartView() {
        consoleView.start();
        verify(startView, times(1)).interact();
    }
}
