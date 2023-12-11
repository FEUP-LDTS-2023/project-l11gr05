package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.menu.ColorPaletteMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorPaletteMenuTest {
    @Test
    public void testColorPaletteMenuCreation() {
        ColorPaletteMenu colorPaletteMenu = new ColorPaletteMenu();

        assertNotNull(colorPaletteMenu);
        assertNotNull(colorPaletteMenu.getColorPalette());
        assertTrue(colorPaletteMenu.isColorSelected(0));
        assertFalse(colorPaletteMenu.isColorSelected(1));
        assertFalse(colorPaletteMenu.isColorSelected(2));
        assertFalse(colorPaletteMenu.isColorSelected(3));
        assertEquals(0, colorPaletteMenu.getSelectedColorIndex());
    }

    @Test
    public void testNavigateLeft() {
        ColorPaletteMenu colorPaletteMenu = new ColorPaletteMenu();
        colorPaletteMenu.navigateLeft();

        assertFalse(colorPaletteMenu.isColorSelected(0));
        assertFalse(colorPaletteMenu.isColorSelected(1));
        assertFalse(colorPaletteMenu.isColorSelected(2));
        assertFalse(colorPaletteMenu.isColorSelected(3));
        assertTrue(colorPaletteMenu.isColorSelected(colorPaletteMenu.getColorPalette().size() - 1));
    }

    @Test
    public void testNavigateRight() {
        ColorPaletteMenu colorPaletteMenu = new ColorPaletteMenu();
        colorPaletteMenu.navigateRight();

        assertFalse(colorPaletteMenu.isColorSelected(0));
        assertTrue(colorPaletteMenu.isColorSelected(1));

        colorPaletteMenu.navigateRight();
        assertFalse(colorPaletteMenu.isColorSelected(1));
        assertTrue(colorPaletteMenu.isColorSelected(2));
    }

    @Test
    public void testResetSelectedColorIndex() {
        ColorPaletteMenu colorPaletteMenu = new ColorPaletteMenu();
        colorPaletteMenu.navigateRight();
        colorPaletteMenu.resetSelectedColorIndex();

        assertTrue(colorPaletteMenu.isColorSelected(0));
        assertFalse(colorPaletteMenu.isColorSelected(1));
        assertFalse(colorPaletteMenu.isColorSelected(2));
        assertFalse(colorPaletteMenu.isColorSelected(3));
    }

    @Test
    public void testNavigateUpAndDown() {
        ColorPaletteMenu colorPaletteMenu = new ColorPaletteMenu();

        assertDoesNotThrow(() -> colorPaletteMenu.navigateUp());
        assertDoesNotThrow(() -> colorPaletteMenu.navigateDown());
    }
}
