package usantatecla.draughts.views;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.utils.Console;

public class PlayViewTest {
    @Mock
    private Console console;

    @Mock
    GameView gameView;

    @Mock
    PlayController playController;

    @InjectMocks
    private PlayView playView;

    private static final String WHITES_MOVE = "Mueven las blancas: ";
    private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
    private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenPlayViewWhenInteractThenVerifyCancels() {
        when(this.playController.getColor()).thenReturn(Color.WHITE);
        when(this.console.readString(anyString())).thenReturn("-1");
        this.playView.interact(playController);
        verify(this.console, times(1)).readString(WHITES_MOVE);
        verify(this.playController, times(1)).cancel();
    }

    @Test
    public void givenPlayViewWhenInteractThenVerifyWritesError() {
        when(this.playController.getColor()).thenReturn(Color.WHITE);
        when(this.console.readString(anyString())).thenReturn("ERROR").thenReturn("-1");
        this.playView.interact(playController);
        verify(this.console, times(2)).readString(WHITES_MOVE);
        verify(this.console, times(1)).writeln(ERROR_MESSAGE);
    }

    @Test
    public void givenPlayViewWhenInteractThenVerifyMoves() {
        when(this.playController.getColor()).thenReturn(Color.WHITE);
        when(this.playController.move()).thenReturn(null);
        when(this.playController.isBlocked()).thenReturn(true);
        when(this.console.readString(anyString())).thenReturn("71.62");
        this.playView.interact(playController);
        verify(this.console, times(1)).readString(WHITES_MOVE);
        verify(this.console, times(1)).writeln(LOST_MESSAGE);
    }
}
