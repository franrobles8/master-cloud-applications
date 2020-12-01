package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class StartControllerTest {
    
    @Mock
    private ControllersVisitor controllersVisitor;

    @InjectMocks
    private StartController startController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
	void testGivenStartControllerWhenAcceptThenControllersVisitorVisit() {
        this.startController.accept(this.controllersVisitor);
		verify(this.controllersVisitor).visit(this.startController);
    }
}
