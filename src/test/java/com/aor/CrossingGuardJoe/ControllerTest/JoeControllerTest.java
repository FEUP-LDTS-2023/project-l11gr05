package com.aor.CrossingGuardJoe.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.aor.CrossingGuardJoe.controller.game.elements.JoeController;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;
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

        verify(joeController.getModel().getJoe()).passSign();
    }

    @Test
    public void testJoeStopSign() {
        joeController.joeStopSign();

        verify(joeController.getModel().getJoe()).isRaisingStopSign();
    }

    @Test
    public void testJoeActionMoveLeft() {
        Position initialPos = new Position(10, 20);

        joeController.JoeAction(initialPos, 'l');

        verify(joeController.getModel().getJoe()).isWalkingToLeft();
        verify(joeController.getModel().getJoe()).setPosition(initialPos);
    }

    @Test
    public void testJoeActionMoveRight() {
        Position initialPos = new Position(10, 20);

        joeController.JoeAction(initialPos, 'r');

        verify(joeController.getModel().getJoe()).isWalkingToRight();
        verify(joeController.getModel().getJoe()).setPosition(initialPos);
    }
}
