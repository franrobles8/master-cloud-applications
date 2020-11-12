package usantatecla.draughts.views;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.Controller;
import usantatecla.draughts.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class GameViewTest {
    @Spy
    private Console console;

    @Mock
    private Controller controller;

    @Mock
    private InteractorController interactorController;

    @InjectMocks
    private GameView gameView;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenGameViewWhenWriteNumberLinesThenVerifyCallsDone() {
        when(this.interactorController.getDimension()).thenReturn(3);
        this.gameView.write(this.interactorController);
        verify(this.interactorController, times(13)).getDimension();
        verify(this.console, times(20)).write(anyString());
        verify(this.console, times(2)).writeln();
        verify(this.console, times(3)).writeln(anyString());
    }
}
