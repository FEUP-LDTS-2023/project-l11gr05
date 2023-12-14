package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;

import java.util.Arrays;
import java.util.List;

public class GameOverMenu implements MenuNavigator {
    private final boolean isWin;
    private Road currentGame;
    private final List<Option> options;
    private int optionSelected = 0;

    public GameOverMenu(boolean isWin, Road currentGame) {
        this.isWin = isWin;
        this.currentGame = currentGame;
        this.options = Arrays.asList(
                new Option("Stats", new Position(232, 270), null),
                new Option("Exit", new Position(236, 310), null)
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

    public boolean isSelectedStats() { return isSelectedOption(0); }

    public boolean isSelectedExit() { return isSelectedOption(1); }

    public boolean isWin() {
        return isWin;
    }

    public Road getCurrentGame() {
        return currentGame;
    }

    public int getOptionSelected() {
        return this.optionSelected;
    }

    @Override
    public void navigateRight() {}

    @Override
    public void navigateLeft() {}
}
