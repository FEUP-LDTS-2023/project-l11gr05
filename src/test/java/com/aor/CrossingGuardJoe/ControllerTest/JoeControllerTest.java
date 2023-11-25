package com.aor.CrossingGuardJoe.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.aor.CrossingGuardJoe.controller.game.JoeController;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
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
        joeController = new JoeController(roadMock);
    }

    @Test
    public void testMoveJoeLeft() {
        Position initialPos = new Position(10, 20);
        when(joeController.getModel().getJoe().getPosition()).thenReturn(initialPos);

        joeController.moveJoeLeft();

        verify(joeController.getModel().getJoe()).setPosition(new Position(4, 20));
    }

    @Test
    public void testMoveJoeRight() {
        Position initialPos = new Position(10, 20);
        when(joeController.getModel().getJoe().getPosition()).thenReturn(initialPos);

        joeController.moveJoeRight();

        verify(joeController.getModel().getJoe()).setPosition(new Position(16, 20));
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
