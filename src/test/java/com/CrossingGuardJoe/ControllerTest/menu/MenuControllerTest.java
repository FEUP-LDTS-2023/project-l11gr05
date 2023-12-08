package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.MenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.GameState;
import com.CrossingGuardJoe.states.menu.CustomizeMenuState;
import com.CrossingGuardJoe.states.menu.InstructionsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MenuControllerTest {
    private Menu mockMenu;
    private GUI mockGUI;
    private Game game;
    private MenuController menuController;

    @BeforeEach
    void setUp() {
        mockMenu = mock(Menu.class);
        mockGUI = mock(GUI.class);
        game = mock(Game.class);
        menuController = new MenuController(mockMenu);
    }

    @Test
    void testNextActionUp() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.UP);
        menuController.nextAction(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(mockMenu).navigateUp();
    }

    @Test
    void testNextActionDown() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        menuController.nextAction(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(mockMenu).navigateDown();
    }

    @Test
    void testNextActionSelectStartGame() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockMenu.isSelectedStartGame()).thenReturn(true);


        menuController.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(mockMenu).isSelectedStartGame();
        verify(game).setState(any(GameState.class));
    }

    @Test
    void testNextActionSelectInstructions() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockMenu.isSelectedInstructions()).thenReturn(true);

        menuController.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(mockMenu).isSelectedInstructions();
        verify(game).setState(any(InstructionsMenuState.class));
    }

    @Test
    void testNextActionSelectCustomize() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockMenu.isSelectedCustomize()).thenReturn(true);

        menuController.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(mockMenu).isSelectedCustomize();
        verify(game).setState(any(CustomizeMenuState.class));
    }

    /*@Test
    void testNextActionSelectExit() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockMenu.isSelectedExit()).thenReturn(true);

        menuController.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(mockMenu).isSelectedExit();
        verify(game).setState(null);
    }*/
}
