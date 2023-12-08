package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.InstructionsMenuController;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.states.menu.InstructionsMenuState;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.InstructionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstructionsMenuStateTest {
    private InstructionsMenu instructionsMenu;
    private InstructionsMenuState instructionsMenuState;

    @BeforeEach
    public void setUp() {
        instructionsMenu = new InstructionsMenu();
        instructionsMenuState = new InstructionsMenuState(instructionsMenu);
    }

    @Test
    public void testGetController() {
        Controller<InstructionsMenu> controller = instructionsMenuState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof InstructionsMenuController);
        assertEquals(instructionsMenu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<InstructionsMenu> viewer = instructionsMenuState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof InstructionsMenuViewer);
        assertEquals(instructionsMenu, viewer.getModel());
    }
}
