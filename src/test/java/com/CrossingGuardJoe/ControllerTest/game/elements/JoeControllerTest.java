package com.CrossingGuardJoe.ControllerTest.game.elements;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Joe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class JoeControllerTest {
    private JoeController joeController;
    private Road mockRoad;
    private Position mockPosition;
    private Joe mockJoe;

    @BeforeEach
    public void setUp() {
        mockRoad = Mockito.mock(Road.class);
        mockJoe = Mockito.mock(Joe.class);
        mockPosition = Mockito.mock(Position.class);

        when(mockJoe.getPosition()).thenReturn(mockPosition);

        // Create JoeController using the real Joe instance from your game logic
        JoeController realJoeController = new JoeController(mockRoad);
        this.mockJoe = realJoeController.getModel().getJoe();  // Use the Joe instance from the real controller
        joeController = spy(realJoeController);  // Use spy to partially mock the real controller
    }


    @Test
    public void testMoveJoeLeft() {
        // Call the method to be tested
        joeController.moveJoeLeft();

        // Verify that getPosition is invoked
        verify(mockJoe, times(2)).getPosition(); // Verify twice because it's called twice in the moveJoe method

        // Verify that setPosition is invoked with any(Position.class) argument
        verify(mockJoe).setPosition(eq(mockPosition));
    }
}
