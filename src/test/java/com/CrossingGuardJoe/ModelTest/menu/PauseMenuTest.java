package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PauseMenuTest {
    private PauseMenu pauseMenu;

    @BeforeEach
    public void setUp() {
        Road currentGame = new Road();
        pauseMenu = new PauseMenu(currentGame);
    }

    @Test
    public void testGetCurrentGame() {
        Road expectedRoad = new Road();
        PauseMenu pauseMenu = new PauseMenu(expectedRoad);

        Road actualRoad = pauseMenu.getCurrentGame();

        assertEquals(expectedRoad, actualRoad, "Current game should match");
    }

    @Test
    public void testNavigateUp() {
        int initialOption = pauseMenu.isSelectedOption(0) ? 0 : 1;
        pauseMenu.navigateUp();
        int expectedOption = (initialOption - 1 + pauseMenu.getNumberOptions()) % pauseMenu.getNumberOptions();
        assertTrue(pauseMenu.isSelectedOption(expectedOption), "Should navigate up to the previous option");
    }

    @Test
    public void testNavigateDown() {
        int initialOption = pauseMenu.isSelectedOption(0) ? 0 : 1;
        pauseMenu.navigateDown();
        int expectedOption = (initialOption + 1) % pauseMenu.getNumberOptions();
        assertTrue(pauseMenu.isSelectedOption(expectedOption), "Should navigate down to the next option");
    }

    @Test
    public void testNavigateUpAtFirstOption() {
        while (!pauseMenu.isSelectedOption(0)) {
            pauseMenu.navigateUp();
        }

        int initialOption = 0;
        pauseMenu.navigateUp();
        assertFalse(pauseMenu.isSelectedOption(initialOption), "Should navigate up beyond the first option");
    }

    @Test
    public void testNavigateDownAtLastOption() {
        while (!pauseMenu.isSelectedOption(pauseMenu.getNumberOptions() - 1)) {
            pauseMenu.navigateDown();
        }

        int initialOption = pauseMenu.getNumberOptions() - 1;
        pauseMenu.navigateDown();
        assertFalse(pauseMenu.isSelectedOption(initialOption), "Should navigate down beyond the last option");
    }

    @Test
    public void testGetOption() {
        List<Option> expectedOptions = Arrays.asList(
                new Option("Resume", new Position(228, 220), null),
                new Option("Stats", new Position(232, 260), null),
                new Option("Exit", new Position(237, 300), null)
        );

        for (int i = 0; i < expectedOptions.size(); i++) {
            Option actualOption = pauseMenu.getOption(i);
            assertEquals(expectedOptions.get(i), actualOption, "Options should match");
        }
    }

    @Test
    public void testGetNumberOptions() {
        int numOptions = pauseMenu.getNumberOptions();
        assertEquals(3, numOptions, "Number of options should be 3");
    }

    @Test
    public void testIsSelectedResume() {
        assertTrue(pauseMenu.isSelectedResume(), "Resume option should be selected initially");
        pauseMenu.navigateDown();
        assertFalse(pauseMenu.isSelectedResume());
        assertTrue(pauseMenu.isSelectedStats());
        pauseMenu.navigateDown();
        assertFalse(pauseMenu.isSelectedStats());
        assertTrue(pauseMenu.isSelectedExit());
    }

    @Test
    public void testIsSelectedStats() {
        assertFalse(pauseMenu.isSelectedStats(), "Stats option should not be selected initially");
    }

    @Test
    public void testIsSelectedExit() {
        assertFalse(pauseMenu.isSelectedExit(), "Exit option should not be selected initially");
    }

    @Test
    public void testNavigateRightAndLeft() {
        assertDoesNotThrow(() -> pauseMenu.navigateRight());
        assertDoesNotThrow(() -> pauseMenu.navigateLeft());
    }
}
