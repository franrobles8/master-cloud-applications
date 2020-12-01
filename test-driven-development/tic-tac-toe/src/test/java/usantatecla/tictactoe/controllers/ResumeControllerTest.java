package usantatecla.tictactoe.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class ResumeControllerTest {
 
    
    @Mock
    private ControllersVisitor controllersVisitor;

    @InjectMocks
    private ResumeController resumeController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
	void testGivenPlayControllerWhenAcceptThenControllersVisitorVisit() {
        this.resumeController.accept(this.controllersVisitor);
		verify(this.controllersVisitor).visit(this.resumeController);
    }
}
