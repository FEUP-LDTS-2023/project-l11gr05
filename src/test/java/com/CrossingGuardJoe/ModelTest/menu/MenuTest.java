package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testMenuCreation() {
        Menu menu = new Menu();

        assertNotNull(menu);
        assertEquals(4, menu.getNumberOptions());
        assertTrue(menu.isSelectedStartGame());
        assertFalse(menu.isSelectedInstructions());
        assertFalse(menu.isSelectedCustomize());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    public void testNavigateUp() {
        Menu menu = new Menu();

        menu.navigateUp();
        assertTrue(menu.isSelectedExit());
        menu.navigateUp();
        assertTrue(menu.isSelectedCustomize());
        menu.navigateUp();
        assertTrue(menu.isSelectedInstructions());
        menu.navigateUp();
        assertTrue(menu.isSelectedStartGame());
        menu.navigateUp();
        assertFalse(menu.isSelectedStartGame());
        assertTrue(menu.isSelectedExit());
    }

    @Test
    public void testNavigateDown() {
        Menu menu = new Menu();

        menu.navigateDown();
        assertTrue(menu.isSelectedInstructions());
        menu.navigateDown();
        assertTrue(menu.isSelectedCustomize());
        menu.navigateDown();
        assertTrue(menu.isSelectedExit());
        menu.navigateDown();
        assertTrue(menu.isSelectedStartGame());
        menu.navigateDown();
        assertFalse(menu.isSelectedStartGame());
        assertTrue(menu.isSelectedInstructions());
    }

    @Test
    public void testGetOption() {
        Menu menu = new Menu();

        Option option = menu.getOption(2);

        assertNotNull(option);
    }

    @Test
    public void testNavigateRightAndLeft() {
        Menu menu = new Menu();

        assertDoesNotThrow(() -> menu.navigateRight());
        assertDoesNotThrow(() -> menu.navigateLeft());
    }
}
