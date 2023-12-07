package com.CrossingGuardJoe.ControllerTest.game.elements;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.controller.game.RoadController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.RoadBuilder;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class JoeControllerTest {
    private JoeController joeController;
    private Road road;
    private Joe joe;
    private Car car;
    private RoadBuilder roadBuilder;
    private RoadController roadController;
    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = Mockito.mock(GameController.class);
        roadBuilder = Mockito.mock(RoadBuilder.class);
        road = Mockito.mock(Road.class);
        roadController = Mockito.mock(RoadController.class);
        joeController = new JoeController(road);
        joe = Mockito.mock(Joe.class);

        when(road.getJoe()).thenReturn(joe);

    }


    @Test
    void nextActionTest() {
        // Test action NONE
        joeController.nextAction(null, GUI.ACTION.NONE, 0);
        verify(joeController.getModel().getJoe(), times(1)).stopWalking();

        // Test action UP
        joeController.nextAction(null, GUI.ACTION.UP, 0);
        verify(joe, times(1)).startRaisingStopSign();

        // Reset mock
        reset(joe);

        // Test action DOWN
        joeController.nextAction(null, GUI.ACTION.DOWN, 0);
        verify(joe, times(1)).startRaisingPassSign();

        // Reset mock
        reset(joe);

        /*// Test action LEFT
        joeController.nextAction(null, GUI.ACTION.LEFT, 0);
        verify(joe, times(1)).startWalkingToLeft();
        verify(joe, times(1)).setPosition(any());

        // Reset mock
        reset(joe);

        // Test action RIGHT
        joeController.nextAction(null, GUI.ACTION.RIGHT, 0);
        verify(joe, times(1)).startWalkingToRight();
        verify(joe, times(1)).setPosition(any());

        // Reset mock
        reset(joe);*/
    }
}
