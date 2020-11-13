package usantatecla.draughts.views;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

public class ResumeViewTest {
    @Mock
    YesNoDialog yesNoDialog;

    @Mock
    ResumeController resumeController;

    @InjectMocks
    ResumeView resumeView;

    private static final String MESSAGE = "¿Queréis jugar otra";

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeViewWhenInteractAndResumeThenReset() throws IOException {
        when(yesNoDialog.read(MESSAGE)).thenReturn(true);
        this.resumeView.interact(this.resumeController);
        verify(resumeController, times(1)).reset();
    }

    @Test
    public void givenResumeViewWhenInteractAndResumeThenNext() throws IOException {
        when(yesNoDialog.read(MESSAGE)).thenReturn(false);
        this.resumeView.interact(this.resumeController);
        verify(resumeController, times(1)).next();
    }
}
