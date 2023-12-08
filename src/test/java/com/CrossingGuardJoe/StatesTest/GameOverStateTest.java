package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.GameOverMenuController;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.states.menu.GameOverState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameOverStateTest {
    private GameOverMenu gameOverMenu;
    private GameOverState gameOverState;

    @BeforeEach
    public void setUp() {
        gameOverMenu = mock(GameOverMenu.class);
        gameOverState = new GameOverState(gameOverMenu);
    }

    @Test
    public void testGetController() {
        Controller<GameOverMenu> controller = gameOverState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof GameOverMenuController);
        assertEquals(gameOverMenu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<GameOverMenu> viewer = gameOverState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameOverViewer);
        assertEquals(gameOverMenu, viewer.getModel());
    }
}
