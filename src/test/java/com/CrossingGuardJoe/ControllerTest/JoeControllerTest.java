package com.CrossingGuardJoe.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Joe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JoeControllerTest {
    @Mock
    private Road roadMock;

    private JoeController joeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Joe joeMock = mock(Joe.class);
        roadMock = mock(Road.class);
        when(roadMock.getJoe()).thenReturn(joeMock);
        joeController = new JoeController(roadMock);
    }

    @Test
    public void testJoePassSign() {
        joeController.joePassSign();

        verify(joeController.getModel().getJoe()).getIsPassSign();
    }

    @Test
    public void testJoeStopSign() {
        joeController.joeStopSign();

        verify(joeController.getModel().getJoe()).getIsRaisingStopSign();
    }

    @Test
    public void testJoeActionMoveLeft() {
        Position initialPos = new Position(10, 20);

        joeController.JoeAction(initialPos, 'l');

        verify(joeController.getModel().getJoe()).getIsWalkingToLeft();
        verify(joeController.getModel().getJoe()).setPosition(initialPos);
    }

    @Test
    public void testJoeActionMoveRight() {
        Position initialPos = new Position(10, 20);

        joeController.JoeAction(initialPos, 'r');

        verify(joeController.getModel().getJoe()).getIsWalkingToLeft();
        verify(joeController.getModel().getJoe()).setPosition(initialPos);
    }
}
