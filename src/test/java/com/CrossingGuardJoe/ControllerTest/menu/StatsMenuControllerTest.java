package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.StatsMenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class StatsMenuControllerTest {
    private StatsMenu statsMenu;
    private GUI gui;
    private Game game;
    private StatsMenuController controller;

    @BeforeEach
    public void setUp() {
        statsMenu = mock(StatsMenu.class);
        gui = mock(GUI.class);
        game = mock(Game.class);
        controller = new StatsMenuController(statsMenu);
    }

    @Test
    public void testEsc() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        controller.nextAction(game, GUI.ACTION.ESC, System.currentTimeMillis());

        verify(game).popState();
    }
}
