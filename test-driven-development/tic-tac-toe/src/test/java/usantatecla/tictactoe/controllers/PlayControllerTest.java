package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class PlayControllerTest {

    @Mock
    private ControllersVisitor controllersVisitor;

    @InjectMocks
    private PlayController playController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
	void testGivenPlayControllerWhenAcceptThenControllersVisitorVisit() {
        this.playController.accept(this.controllersVisitor);
		verify(this.controllersVisitor).visit(this.playController);
    }
}
