package usantatecla.draughts.views;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.builders.game.GameBuilder;
import usantatecla.draughts.controllers.Controller;
import usantatecla.draughts.utils.Console;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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

    @Captor
    ArgumentCaptor<String> argumentCaptor;

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

    @Test
    public void givenGameViewWhenInteractThenOk(){
        Game game = new GameBuilder().build();
        StartController startController = new StartController(game, new State());
        this.gameView.write(startController);
        verify(console, times(90)).write(argumentCaptor.capture());
        List<String> rows = Arrays.asList(
        " 12345678",
        "1 n n n n",
        "2n n n n ",
        "3 n n n n",
        "4        ",
        "5        ",
        "6b b b b ",
        "7 b b b b",
        "8b b b b ",
        " 12345678");
        assertEquals(listToString(rows), listToString(argumentCaptor.getAllValues()));
    }

    private static String listToString(List<String> strings){
        StringBuilder listToStringBuilder = new StringBuilder();
        strings.forEach(listToStringBuilder::append);
        return listToStringBuilder.toString();
    }
}
