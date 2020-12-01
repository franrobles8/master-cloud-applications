package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
		this.view.interact(startController);
	    verify(this.startController).accept(this.view);
	}
	
	@Test
	void testGivenViewWhenInteractPlayControllerThenPlayViewInteractWithPlayController() {
		this.view.interact(playController);
		verify(this.playController).accept(this.view);
	}
	
	@Test
	void testGivenViewWhenInteractResumeControllerThenResumeViewInteractWithResumeController() {
		this.view.interact(resumeController);
		verify(this.resumeController).accept(this.view);
    }
    
    @Test
    public void givenConsoleViewTestWhenStartThenInteractsWithStartController() {
        this.consoleView.interact(this.startController);
        verify(startView, times(1)).interact(this.startController);
    }

    @Test
    public void givenConsoleViewTestWhenPlayThenInteractsWithPlayController() {
        this.consoleView.interact(this.playController);
        verify(playView, times(1)).interact(this.playController);
    }

    @Test
    public void givenConsoleViewTestWhenIsResumedThenInteractsWithResumeController() {
        this.consoleView.interact(this.resumeController);
        verify(resumeView, times(1)).interact(this.resumeController);
    }

}
