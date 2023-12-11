package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.Option;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuTest {
    @Test
    public void testIsSelectedOption() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());

        boolean isSelected0 = gameOverMenu.isSelectedOption(0);
        boolean isSelected1 = gameOverMenu.isSelectedOption(1);
        assertTrue(isSelected0);
        assertFalse(isSelected1);
    }

    @Test
    public void testIsSelectedStats() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        boolean isSelectedStats = gameOverMenu.isSelectedStats();
        assertTrue(isSelectedStats, "Stats option should be selected");
    }

    @Test
    public void testIsSelectedExit() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        boolean isSelectedExit = gameOverMenu.isSelectedExit();
        assertFalse(isSelectedExit, "Exit option should not be selected initially");
    }

    @Test
    public void testGetOption() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        List<Option> expectedOptions = Arrays.asList(
                new Option("Stats", new Position(232, 270), null),
                new Option("Exit", new Position(236, 310), null)
        );

        for (int i = 0; i < expectedOptions.size(); i++) {
            Option actualOption = gameOverMenu.getOption(i);
            assertEquals(expectedOptions.get(i), actualOption, "Options should match");
        }
    }

    @Test
    public void testGetNumberOptions() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        int numOptions = gameOverMenu.getNumberOptions();
        assertEquals(2, numOptions, "Number of options should be 2");
    }

    @Test
    public void testIsWin() {
        GameOverMenu winMenu = new GameOverMenu(true, new Road());
        GameOverMenu loseMenu = new GameOverMenu(false, new Road());

        boolean isWin = winMenu.isWin();
        boolean isLose = loseMenu.isWin();

        assertTrue(isWin, "Game Over Menu with win should return true for isWin");
        assertFalse(isLose, "Game Over Menu with lose should return false for isWin");
    }

    @Test
    public void testGetCurrentGame() {
        Road expectedRoad = new Road();
        GameOverMenu gameOverMenu = new GameOverMenu(true, expectedRoad);

        Road actualRoad = gameOverMenu.getCurrentGame();

        assertEquals(expectedRoad, actualRoad, "Current game should match");
    }

    @Test
    public void testNavigateUp() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        int initialOptionSelected = gameOverMenu.getOptionSelected();

        gameOverMenu.navigateUp();
        int newOptionSelected = gameOverMenu.getOptionSelected();

        assertEquals((initialOptionSelected - 1 + gameOverMenu.getNumberOptions()) % gameOverMenu.getNumberOptions(),
                newOptionSelected, "Navigate Up should select the previous option");
    }

    @Test
    public void testNavigateDown() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());
        int initialOptionSelected = gameOverMenu.getOptionSelected();

        gameOverMenu.navigateDown();
        int newOptionSelected = gameOverMenu.getOptionSelected();

        assertEquals((initialOptionSelected + 1) % gameOverMenu.getNumberOptions(),
                newOptionSelected, "Navigate Down should select the next option");
    }

    @Test
    public void testNavigateRightAndLeft() {
        GameOverMenu gameOverMenu = new GameOverMenu(true, new Road());

        assertDoesNotThrow(() -> gameOverMenu.navigateRight());
        assertDoesNotThrow(() -> gameOverMenu.navigateLeft());
    }
}
