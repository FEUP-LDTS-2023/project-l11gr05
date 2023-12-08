package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.PauseMenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.states.menu.StatsMenuStates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PauseMenuControllerTest {
    private PauseMenu pauseMenu;
    private GUI gui;
    private Game game;
    private PauseMenuController controller;
    private Joe joe;
    private Road road;

    @BeforeEach
    public void setUp() {
        pauseMenu = mock(PauseMenu.class);
        gui = mock(GUI.class);
        game = mock(Game.class);
        joe = mock(Joe.class);
        road = mock(Road.class);

        controller = new PauseMenuController(pauseMenu);
    }

    @Test
    public void testNextActionUp() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        controller.nextAction(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(pauseMenu).navigateUp();
    }

    @Test
    public void testNextActionDown() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        controller.nextAction(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(pauseMenu).navigateDown();
    }

    @Test
    public void testSelectResume() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(pauseMenu.isSelectedResume()).thenReturn(true);

        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(pauseMenu).isSelectedResume();
        verify(game).popState();
    }

    @Test
    public void testSelectStats() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(pauseMenu.isSelectedStats()).thenReturn(true);
        when(pauseMenu.getCurrentGame()).thenReturn(road);
        when(road.getJoe()).thenReturn(joe);
        when(road.getCurrentLevel()).thenReturn(1);
        when(joe.getScore()).thenReturn(0);
        when(game.getHighestScore()).thenReturn(0);
        when(game.getHighestLevel()).thenReturn(1);

        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(pauseMenu).isSelectedStats();
        verify(pauseMenu, times(2)).getCurrentGame();
        verify(game).getHighestScore();
        verify(game).getHighestLevel();
        verify(game).setState(any(StatsMenuStates.class));
    }

    @Test
    public void testSelectedExit() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(pauseMenu.isSelectedExit()).thenReturn(true);

        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(pauseMenu).isSelectedExit();
        verify(game, times(2)).popState();
    }
}
