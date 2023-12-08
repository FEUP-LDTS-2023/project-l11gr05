package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomizeMenuTest {
    @Test
    public void testOptionSelection() {
        CustomizeMenu customizeMenu = new CustomizeMenu();

        // Select Joe submenu options
        customizeMenu.navigateLeft(); // Move to Joe submenu
        assertTrue(customizeMenu.isSelectedJoeCustomize());

        customizeMenu.navigateUp();
        assertTrue(customizeMenu.isSelectedJoeCap());

        customizeMenu.navigateDown(); // Move to Joe Clothes
        assertTrue(customizeMenu.isSelectedJoeClothes());

        customizeMenu.navigateDown(); // Move to Joe Vest
        assertTrue(customizeMenu.isSelectedJoeVest());

        customizeMenu.navigateDown(); // Move to Joe Shoes
        assertTrue(customizeMenu.isSelectedJoeShoes());

        customizeMenu.navigateUp();
        customizeMenu.navigateUp();

        // Select Kids submenu options
        customizeMenu.navigateRight(); // Move to Kids submenu
        assertTrue(customizeMenu.isSelectedKidsCustomize());

        assertFalse(customizeMenu.isSelectedKidsShirt());
        assertTrue(customizeMenu.isSelectedKidsPants());

        customizeMenu.navigateDown(); // Move to Kids Backpack
        assertTrue(customizeMenu.isSelectedKidsBackpack());

        customizeMenu.navigateDown(); // Move to Kids Shoes
        assertTrue(customizeMenu.isSelectedKidsShoes());

        // Select Cars submenu options
        customizeMenu.navigateRight(); // Move to Cars submenu
        customizeMenu.navigateRight();
        assertTrue(customizeMenu.isSelectedCarsCustomize());

        customizeMenu.navigateDown();
        assertTrue(customizeMenu.isSelectedCarsBody());
    }

    @Test
    public void testColorChange() {
        CustomizeMenu customizeMenu = new CustomizeMenu();
        customizeMenu.setColorChange('A', 'B');

        assertEquals('A', customizeMenu.getOldColor());
        assertEquals('B', customizeMenu.getNewColor());
        assertEquals(0, customizeMenu.getColorPaletteMenu().getSelectedColorIndex());
    }

    @Test
    public void testGetDefinedColors() {
        CustomizeMenu customizeMenu = new CustomizeMenu();
        List<Option> definedColors = customizeMenu.getDefinedColors();

        assertNotNull(definedColors);
    }

    @Test
    public void testSetColorPaletteSelected() {
        CustomizeMenu customizeMenu = new CustomizeMenu();

        assertFalse(customizeMenu.isColorPaletteSelected());

        customizeMenu.setColorPaletteSelected(true);
        assertTrue(customizeMenu.isColorPaletteSelected());

        customizeMenu.setColorPaletteSelected(false);
        assertFalse(customizeMenu.isColorPaletteSelected());
    }

    @Test
    public void testGetMenuLevels() {
        CustomizeMenu customizeMenu = new CustomizeMenu();
        List<List<Option>> menuLevels = customizeMenu.getMenuLevels();

        assertNotNull(menuLevels);
        assertFalse(menuLevels.isEmpty());
    }

    @Test
    public void testGetSelectedColorChar() {
        CustomizeMenu customizeMenu = new CustomizeMenu();

        customizeMenu.navigateLeft();
        customizeMenu.navigateDown();

        char selectedColorChar = customizeMenu.getSelectedColorChar();

        assertEquals('!', selectedColorChar);
    }
}
