package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.FontImageFactory;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<Option> options;
    private int optionSelected = 0;

    public Menu() {

        this.options = Arrays.asList(
                new Option(new Position(203, 220), new FontImageFactory().getImageRepresentation("START GAME")),
                new Option(new Position(195, 260), new FontImageFactory().getImageRepresentation("INSTRUCTIONS")),
                new Option(new Position(207, 300), new FontImageFactory().getImageRepresentation("CUSTOMIZE")),
                new Option(new Position(226, 340), new FontImageFactory().getImageRepresentation("EXIT"))
        );
    }

    public void nextOption() {
        optionSelected = (optionSelected + 1) % options.size();
    }

    public void previousOption() {
        optionSelected = (optionSelected - 1 + options.size()) % options.size();
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

    public boolean isSelectedStartGame() { return isSelectedOption(0); }

    public boolean isSelectedInstructions() { return isSelectedOption(1); }

    public boolean isSelectedCustomize() { return isSelectedOption(2); }


    public boolean isSelectedExit() { return isSelectedOption(3); }

    public int getOptionSelected() {
        return optionSelected;
    }
}
