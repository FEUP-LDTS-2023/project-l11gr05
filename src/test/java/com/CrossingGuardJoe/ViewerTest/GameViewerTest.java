package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {

    GameViewer gameViewer;
    GUI guiMock;
    Road roadMock;
    Position carPosition;
    Position kidPosition;
    Position joePosition;

    @BeforeEach
    void setUp() {
        guiMock = mock(GUI.class);
        roadMock = mock(Road.class);

        carPosition = mock(Position.class);
        kidPosition = mock(Position.class);
        joePosition = mock(Position.class);

        when(carPosition.getX()).thenReturn(10, 20);
        when(carPosition.getY()).thenReturn(10, 20);
        when(kidPosition.getX()).thenReturn(5, 10);
        when(kidPosition.getY()).thenReturn(5, 10);
        when(joePosition.getX()).thenReturn(15, 25);
        when(joePosition.getY()).thenReturn(15, 25);
    }

}