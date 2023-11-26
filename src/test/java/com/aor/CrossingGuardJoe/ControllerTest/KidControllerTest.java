package com.aor.CrossingGuardJoe.ControllerTest;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.game.elements.KidController;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Kid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class KidControllerTest {
    @Mock
    private Road roadMock;

    private KidController kidController;

    public KidControllerTest() {
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        kidController = new KidController(roadMock);
    }

    @Test
    public void testMoveKid() {
        Kid kidMock = mock(Kid.class);
        Position initialPos = new Position(10, 20);
        when(kidMock.getPosition()).thenReturn(initialPos);

        kidController.moveKid(kidMock);

        verify(kidMock).isWalking();
        verify(kidMock).setPosition(new Position(5, 20));
    }

    @Test
    public void testStopKid() {
        Kid kidMock = mock(Kid.class);
        Position initialPos = new Position(10, 20);
        when(kidMock.getPosition()).thenReturn(initialPos);

        kidController.stopKid(kidMock);

        verify(kidMock).isNotWalking();
        verify(kidMock, never()).setPosition(any(Position.class));
    }

    @Test
    public void testKidActionMove() {
        Kid kidMock = mock(Kid.class);
        Position initialPos = new Position(10, 20);

        kidController.KidAction(kidMock, initialPos, 'p');

        verify(kidMock).isWalking();
        verify(kidMock).setPosition(initialPos);
    }

    @Test
    public void testKidActionStop() {
        Kid kidMock = mock(Kid.class);
        Position initialPos = new Position(10, 20);

        kidController.KidAction(kidMock, initialPos, 's');

        verify(kidMock).isNotWalking();
        verify(kidMock, never()).setPosition(any(Position.class));
    }

}
