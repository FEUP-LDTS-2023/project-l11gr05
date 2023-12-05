package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;

import java.util.Arrays;
import java.util.List;

public class PauseMenu implements MenuNavigator{
    private final List<Option> options;
    private int optionSelected = 0;

    public PauseMenu() {
        this.options = Arrays.asList(
                new Option("Resume", new Position(210, 220), null),
                new Option("Stats", new Position(220, 260), null),
                new Option("Exit", new Position(226, 340), null)
        );
    }

    @Override
    public void navigateUp() {
        optionSelected = (optionSelected - 1 + options.size()) % options.size();
    }

    @Override
    public void navigateDown() {
        optionSelected = (optionSelected + 1) % options.size();
    }

    public Option getOption(int i) {
        return options.get(i);
    }

    public int getNumberOptions() {
        return options.size();
    }

    public boolean isSelectedOption(int index) {
        return optionSelected == index;
    }

    public boolean isSelectedResume() { return isSelectedOption(0); }

    public boolean isSelectedStats() { return isSelectedOption(1); }

    public boolean isSelectedExit() { return isSelectedOption(2); }

    @Override
    public void navigateRight() {

    }

    @Override
    public void navigateLeft() {

    }
}

