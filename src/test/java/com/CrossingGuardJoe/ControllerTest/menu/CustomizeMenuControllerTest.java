package com.CrossingGuardJoe.ControllerTest.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.menu.CustomizeMenuController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.ColorPaletteMenu;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.viewer.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CustomizeMenuControllerTest {
    private CustomizeMenu customizeMenu;
    private ColorPaletteMenu colorPaletteMenu;
    private GUI gui;
    private Game game;
    private CustomizeMenuController controller;

    @BeforeEach
    public void setUp() {
        customizeMenu = mock(CustomizeMenu.class);
        colorPaletteMenu = mock(ColorPaletteMenu.class);
        gui = mock(GUI.class);
        game = mock(Game.class);
        controller = new CustomizeMenuController(customizeMenu);
    }

    @Test
    public void testNextActionUp() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        controller.nextAction(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(customizeMenu).navigateUp();
    }

    @Test
    public void testNextActionDown() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        controller.nextAction(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(customizeMenu).navigateDown();
    }

    @Test
    public void testNextActionRight1() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.RIGHT);
        controller.nextAction(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(customizeMenu).navigateRight();
    }

    @Test
    public void testNextActionRight2() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(true);
        when(customizeMenu.getColorPaletteMenu()).thenReturn(colorPaletteMenu);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.RIGHT);
        controller.nextAction(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(colorPaletteMenu).navigateRight();
    }

    @Test
    public void testNextActionLeft1() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        controller.nextAction(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(customizeMenu).navigateLeft();
    }

    @Test
    public void testNextActionLeft2() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(true);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        when(customizeMenu.getColorPaletteMenu()).thenReturn(colorPaletteMenu);
        controller.nextAction(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(colorPaletteMenu).navigateLeft();
    }

    @Test
    public void testEsc1() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        controller.nextAction(game, GUI.ACTION.ESC, System.currentTimeMillis());

        verify(game).popState();
    }

    @Test
    public void testEsc2() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(true);
        when(customizeMenu.getColorPaletteMenu()).thenReturn(colorPaletteMenu);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        controller.nextAction(game, GUI.ACTION.ESC, System.currentTimeMillis());
        verify(customizeMenu).setColorPaletteSelected(false);
    }

    @Test
    public void testSelect1() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(customizeMenu).getSelectedColorChar();
        verify(customizeMenu).setColorPaletteSelected(true);
    }

    //Don't know how to get the list of colors
    /*@Test
    public void testSelect2() throws IOException {
        when(customizeMenu.isColorPaletteSelected()).thenReturn(true);
        when(customizeMenu.getColorPaletteMenu()).thenReturn(colorPaletteMenu);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        controller.nextAction(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(customizeMenu).getColorPaletteMenu();
        verify(customizeMenu).setColorChange(any(), any());
        verify(customizeMenu).setColorPaletteSelected(false);
    }*/
}
