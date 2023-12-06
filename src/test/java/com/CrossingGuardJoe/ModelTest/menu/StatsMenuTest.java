package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.menu.StatsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsMenuTest {
    @Test
    public void testGetCurrentScore() {
        int currentScore = 100;
        StatsMenu statsMenu = new StatsMenu(currentScore, 5, 150, 8);

        int actualCurrentScore = statsMenu.getCurrentScore();

        assertEquals(currentScore, actualCurrentScore, "Current score should match");
    }

    @Test
    public void testGetCurrentLevel() {
        int currentLevel = 5;
        StatsMenu statsMenu = new StatsMenu(120, currentLevel, 200, 9);

        int actualCurrentLevel = statsMenu.getCurrentLevel();

        assertEquals(currentLevel, actualCurrentLevel, "Current level should match");
    }

    @Test
    public void testGetHighestScore() {
        int highestScore = 250;
        StatsMenu statsMenu = new StatsMenu(180, 7, highestScore, 10);

        int actualHighestScore = statsMenu.getHighestScore();

        assertEquals(highestScore, actualHighestScore, "Highest score should match");
    }

    @Test
    public void testGetHighestLevel() {
        int highestLevel = 8;
        StatsMenu statsMenu = new StatsMenu(200, 6, 300, highestLevel);

        int actualHighestLevel = statsMenu.getHighestLevel();

        assertEquals(highestLevel, actualHighestLevel, "Highest level should match");
    }
}
