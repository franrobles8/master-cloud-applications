package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogicTest {
    @Mock
    private StartController startController;

    @Mock
    private PlayController playController;

    @Mock
    private ResumeController resumeController;

    @InjectMocks
    private Logic logic;

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenLogicWhenSetUsersThenCallsToStartControllerSetUsers() {
        int users = 2;
        this.logic.setUsers(users);
        verify(this.startController, times(1)).setUsers(users);
    }

    @Test
    public void givenLogicWhenGetMaxPlayersThenCallsToStartControllerGetMaxPlayers() {
        when(this.startController.getMaxPlayers()).thenReturn(2);
        assertThat(this.logic.getMaxPlayers(), is(2));
        verify(this.startController, times(1)).getMaxPlayers();
    }

    @Test
    public void givenLogicWhenIsBoardCompleteThenCallsToPlayControllerIsBoardComplete() {
        when(this.playController.isBoardComplete()).thenReturn(true);
        assertThat(this.logic.isBoardComplete(), is(true));
        verify(this.playController, times(1)).isBoardComplete();
    }

    @Test
    public void givenLogicWhenIsTicTacToeThenCallsToPlayControllerIsTicTacToe() {
        assertThat(this.logic.isTicTacToe(), is(true));
        verify(this.playController, times(1)).isTicTacToe();
    }
}
