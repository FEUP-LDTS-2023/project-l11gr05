package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.CustomizeMenuController;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.states.menu.CustomizeMenuState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.CustomizeMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CustomizeMenuStateTest {
    private CustomizeMenu customizeMenu;
    private CustomizeMenuState customizeMenuState;

    @BeforeEach
    public void setUp() {
        customizeMenu = mock(CustomizeMenu.class);
        customizeMenuState = new CustomizeMenuState(customizeMenu);
    }

    @Test
    public void testGetController() {
        Controller<CustomizeMenu> controller = customizeMenuState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof CustomizeMenuController);
        assertEquals(customizeMenu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<CustomizeMenu> viewer = customizeMenuState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof CustomizeMenuViewer);
        assertEquals(customizeMenu, viewer.getModel());
    }
}
