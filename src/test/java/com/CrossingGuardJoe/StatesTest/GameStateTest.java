package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.game.RoadController;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.states.GameState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {
    private Road road;
    private GameState gameState;

    @BeforeEach
    public void setUp() {
        road = new Road();
        gameState = new GameState(road);
    }

    @Test
    public void testGetController() {
        Controller<Road> controller = gameState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof RoadController);
        assertEquals(road, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<Road> viewer = gameState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);
        assertEquals(road, viewer.getModel());
    }

}
