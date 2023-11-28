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

    public boolean selectedOption(int index) {
        return option == index;
    }

    public boolean StartGame() { return selectedOption(0); }

    public boolean Leaderboard() { return selectedOption(1); }

    public boolean Instructions() { return selectedOption(2); }

    public boolean Exit() { return selectedOption(3); }
}
