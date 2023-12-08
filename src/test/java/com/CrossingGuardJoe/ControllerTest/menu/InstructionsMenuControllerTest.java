package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.InstructionsMenuController;
import com.CrossingGuardJoe.controller.menu.MenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionsMenuControllerTest {
    private InstructionsMenu instructionsMenu;
    private GUI gui;
    private Game game;
    private InstructionsMenuController controller;

    @BeforeEach
    void setUp() {
        instructionsMenu = mock(InstructionsMenu.class);
        gui = mock(GUI.class);
        game = mock(Game.class);
        controller = new InstructionsMenuController(instructionsMenu);
    }

    @Test
    void testNextActionRight() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.RIGHT);
        controller.nextAction(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(instructionsMenu).navigateRight();
    }

    @Test
    void testNextActionLeft() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        controller.nextAction(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(instructionsMenu).navigateLeft();
    }

    @Test
    void testEsc() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        controller.nextAction(game, GUI.ACTION.ESC, System.currentTimeMillis());

        verify(game).popState();
    }
}
