package com.CrossingGuardJoe.StatesTest;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.MenuController;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.menu.MenuState;
import com.CrossingGuardJoe.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.CrossingGuardJoe.viewer.menu.MenuViewer;

import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {
    private Menu menu;
    private MenuState menuState;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        menuState = new MenuState(menu);
    }

    @Test
    public void testGetController() {
        Controller<Menu> controller = menuState.getController();
        assertNotNull(controller);
        assertTrue(controller instanceof MenuController);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void testGetViewer() {
        Viewer<Menu> viewer = menuState.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof MenuViewer);
        assertEquals(menu, viewer.getModel());
    }
}
