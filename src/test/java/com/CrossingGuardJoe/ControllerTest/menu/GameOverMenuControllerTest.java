package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.GameOverMenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.states.menu.StatsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameOverMenuControllerTest {
    private GameOverMenu gameOverMenu;
    private GUI gui;
    private Game game;
    private GameOverMenuController controller;
    private Joe joe;
    private Road road;

    @BeforeEach
    public void setUp() {
        gameOverMenu = mock(GameOverMenu.class);
        gui = mock(GUI.class);
        game = mock(Game.class);
        joe = mock(Joe.class);
        road = mock(Road.class);

        controller = new GameOverMenuController(gameOverMenu);
    }

    @Test
    public void testNextActionUp() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        controller.nextAction(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(gameOverMenu).navigateUp();
    }

    @Test
    public void testNextActionDown() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        controller.nextAction(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(gameOverMenu).navigateDown();
    }

    @Test
    public void testSelectStats() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(gameOverMenu.isSelectedStats()).thenReturn(true);
        when(gameOverMenu.getCurrentGame()).thenReturn(road);
        when(road.getJoe()).thenReturn(joe);
        when(road.getCurrentLevel()).thenReturn(1);
        when(joe.getScore()).thenReturn(0);
        when(game.getHighestScore()).thenReturn(0);
        when(game.getHighestLevel()).thenReturn(1);

        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(gameOverMenu).isSelectedStats();
        verify(gameOverMenu, times(2)).getCurrentGame();
        verify(game).getHighestScore();
        verify(game).getHighestLevel();
        verify(game).setState(any(StatsMenuState.class));
    }

    @Test
    public void testSelectedExit() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(gameOverMenu.isSelectedExit()).thenReturn(true);

        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(gameOverMenu).isSelectedExit();
        assertFalse(gameOverMenu.isWin());
        verify(game).popState();
    }
}
