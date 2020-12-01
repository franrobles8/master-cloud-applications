package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ConsoleViewTest {

    @Mock
    private StartController startController;

    @Mock
    private PlayController playController;

    @Mock
    private ResumeController resumeController;

    @Mock
    private StartView startView;

    @Mock
    private PlayView playView;

    @Mock
    private ResumeView resumeView;

    @InjectMocks
    private ConsoleView consoleView = new ConsoleView();

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
	void testGivenViewWhenInteractStartControllerThenStartViewInteractWithStartController() {
		this.consoleView.interact(startController);
	    verify(this.startController).accept(this.consoleView);
	}
	
	@Test
	void testGivenViewWhenInteractPlayControllerThenPlayViewInteractWithPlayController() {
		this.consoleView.interact(playController);
		verify(this.playController).accept(this.consoleView);
	}
	
	@Test
	void testGivenViewWhenInteractResumeControllerThenResumeViewInteractWithResumeController() {
		this.consoleView.interact(resumeController);
		verify(this.resumeController).accept(this.consoleView);
    }
    
    @Test
    public void givenConsoleViewTestWhenStartThenInteractsWithStartController() {
        this.consoleView.visit(this.startController);
        verify(this.startView, times(1)).interact(this.startController);
    }

    @Test
    public void givenConsoleViewTestWhenPlayThenInteractsWithPlayController() {
        this.consoleView.visit(this.playController);
        verify(this.playView, times(1)).interact(this.playController);
    }

    @Test
    public void givenConsoleViewTestWhenIsResumedThenInteractsWithResumeController() {
        this.consoleView.visit(this.resumeController);
        verify(this.resumeView, times(1)).interact(this.resumeController);
    }

}
