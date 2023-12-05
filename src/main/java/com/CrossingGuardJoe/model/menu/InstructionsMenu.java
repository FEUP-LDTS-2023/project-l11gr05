package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.controller.game.Sounds;
import com.CrossingGuardJoe.controller.game.SoundsController;
import com.CrossingGuardJoe.model.Position;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenu implements MenuNavigator {
    private final int LAST_PAGE = 5;
    private int currentPage;

    public InstructionsMenu() {
        currentPage = 1;
    }

    @Override
    public void navigateUp() {}

    @Override
    public void navigateDown() {}

    @Override
    public void navigateRight() {
        if (currentPage < LAST_PAGE) {
            currentPage++;
            SoundsController.getInstance().play(Sounds.SFX.FLIPPAGE);
        }
    }

    @Override
    public void navigateLeft() {
        if (currentPage > 1) {
            currentPage--;
            SoundsController.getInstance().play(Sounds.SFX.FLIPPAGE);
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return LAST_PAGE;
    }

}