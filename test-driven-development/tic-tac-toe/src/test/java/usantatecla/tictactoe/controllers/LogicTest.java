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
        int maxPlayers = this.logic.getMaxPlayers();
        verify(this.startController, times(1)).getMaxPlayers();
        assertThat(maxPlayers, is(2));
    }

    @Test
    public void givenLogicWhenIsBoardCompleteThenCallsToPlayControllerIsBoardComplete() {
        when(this.playController.isBoardComplete()).thenReturn(true);
        boolean isBoardComplete = this.logic.isBoardComplete();
        verify(this.playController, times(1)).isBoardComplete();
        assertThat(isBoardComplete, is(true));
    }
}
