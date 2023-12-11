package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuTest {
    private InstructionsMenu instructionsMenu;

    @BeforeEach
    public void setUp() {
        instructionsMenu = new InstructionsMenu();
    }

    @Test
    public void testNavigateRight() {
        int initialPage = instructionsMenu.getCurrentPage();
        instructionsMenu.navigateRight();

        assertEquals(initialPage + 1, instructionsMenu.getCurrentPage(), "Page should increase after navigating right");
    }

    @Test
    public void testNavigateLeft() {
        int initialPage = instructionsMenu.getCurrentPage();
        instructionsMenu.navigateRight();
        instructionsMenu.navigateLeft();

        assertEquals(initialPage, instructionsMenu.getCurrentPage(), "Page should decrease after navigating left");
    }

    @Test
    public void testNavigateRightAtLastPage() {
        while (instructionsMenu.getCurrentPage() < instructionsMenu.getTotalPages()) {
            instructionsMenu.navigateRight();
        }

        int lastPage = instructionsMenu.getCurrentPage();
        instructionsMenu.navigateRight();

        assertEquals(lastPage, instructionsMenu.getCurrentPage(), "Page should not increase beyond the last page");
    }

    @Test
    public void testNavigateLeftAtFirstPage() {
        int initialPage = instructionsMenu.getCurrentPage();
        instructionsMenu.navigateLeft();

        assertEquals(initialPage, instructionsMenu.getCurrentPage(), "Page should not decrease beyond the first page");
    }

    @Test
    public void testNavigateUpAndDown() {
        assertDoesNotThrow(() -> instructionsMenu.navigateUp());
        assertDoesNotThrow(() -> instructionsMenu.navigateDown());
    }
}
