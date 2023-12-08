package com.CrossingGuardJoe.StatesTest;


import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.StatsMenuController;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import com.CrossingGuardJoe.states.menu.StatsMenuState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.StatsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class StatsMenuStateTest {
    private StatsMenu statsMenu;
    private StatsMenuState statsMenuState;

    @BeforeEach
    public void setUp() {
        statsMenu = mock(StatsMenu.class);
        statsMenuState = new StatsMenuState(statsMenu);
    }

    @Test
    public void testGetController() {
        Controller<StatsMenu> controller = statsMenuState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof StatsMenuController);
        assertEquals(statsMenu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<StatsMenu> viewer = statsMenuState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof StatsMenuViewer);
        assertEquals(statsMenu, viewer.getModel());
    }
}
