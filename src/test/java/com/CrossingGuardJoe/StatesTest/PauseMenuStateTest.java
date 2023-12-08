package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;

import com.CrossingGuardJoe.controller.menu.PauseMenuController;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.states.menu.PauseMenuState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.PauseMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PauseMenuStateTest {
    private PauseMenu pauseMenu;
    private PauseMenuState pauseMenuState;

    @BeforeEach
    public void setUp() {
        pauseMenu = mock(PauseMenu.class);
        pauseMenuState = new PauseMenuState(pauseMenu);
    }

    @Test
    public void testGetController() {
        Controller<PauseMenu> controller = pauseMenuState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof PauseMenuController);
        assertEquals(pauseMenu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<PauseMenu> viewer = pauseMenuState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof PauseMenuViewer);
        assertEquals(pauseMenu, viewer.getModel());
    }
}
