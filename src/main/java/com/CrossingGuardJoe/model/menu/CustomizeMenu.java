package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomizeMenu {
    private final List<List<Option>> menuLevels;
    private int currentLevel;
    private int optionSelected;

    public CustomizeMenu() {
        this.menuLevels = new ArrayList<>();

        // Level 0
        List<Option> level0 = Arrays.asList(
                new Option(new Position(100, 220), new Text().getTextImage("CUSTOMIZE YOUR CHARACTER")),
                new Option(new Position(200, 260), new Text().getTextImage("JOE")),
                new Option(new Position(200, 300), new Text().getTextImage("KIDS")),
                new Option(new Position(200, 340), new Text().getTextImage("CARS")),
                new Option(new Position(200, 380), new Text().getTextImage("BACK"))
        );

        // Add levels to the menu
        menuLevels.add(level0);

        // Initialize the state
        this.currentLevel = 0;
        this.optionSelected = 0;
    }

    public void navigateLeft() {
        // Move left to a previous level
        currentLevel = Math.max(currentLevel - 1, 0);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    public void navigateRight() {
        // Move right to the next level
        currentLevel = Math.min(currentLevel + 1, menuLevels.size() - 1);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    public void navigateUp() {
        // Move up within the current level
        optionSelected = Math.max(optionSelected - 1, 0);
    }

    public void navigateDown() {
        // Move down within the current level
        optionSelected = Math.min(optionSelected + 1, menuLevels.get(currentLevel).size() - 1);
    }

    public Option getCurrentOption() {
        return menuLevels.get(currentLevel).get(optionSelected);
    }

}
