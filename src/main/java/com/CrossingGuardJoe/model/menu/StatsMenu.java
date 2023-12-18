package com.CrossingGuardJoe.model.menu;

public class StatsMenu {
    private final int currentScore;
    private final int currentLevel;
    private final int highestScore;
    private final int highestLevel;

    public StatsMenu(int currentScore, int currentLevel, int highestScore, int highestLevel) {
        this.currentScore = currentScore;
        this.currentLevel = currentLevel;
        this.highestScore = highestScore;
        this.highestLevel = highestLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public int getHighestScore() {
        return highestScore;
    }
}
