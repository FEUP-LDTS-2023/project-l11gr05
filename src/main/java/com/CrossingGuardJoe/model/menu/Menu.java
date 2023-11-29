package com.CrossingGuardJoe.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int option = 0;

    public Menu() {
        this.options = Arrays.asList("START GAME", "LEADERBOARD", "INSTRUCTIONS", "EXIT");
    }

    public void nextOption() {
        option = (option + 1) % options.size();
    }

    public void previousOption() {
        option = (option - 1 + options.size()) % options.size();
    }

    public String getOption(int i) {
        return options.get(i);
    }

    public int getNumberOptions() {
        return options.size();
    }

    public boolean isSelectedOption(int index) {
        return option == index;
    }

    public boolean isSelectedStartGame() { return isSelectedOption(0); }

    public boolean isSelectedLeaderboard() { return isSelectedOption(1); }

    public boolean isSelectedInstructions() { return isSelectedOption(2); }

    public boolean isSelectedExit() { return isSelectedOption(3); }
}
