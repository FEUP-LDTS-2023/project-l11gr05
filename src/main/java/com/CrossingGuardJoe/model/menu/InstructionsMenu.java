package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;

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
            SoundsController.getInstance().play(Sounds.SFX.FLIPPAGE);
            currentPage++;
        }
    }

    @Override
    public void navigateLeft() {
        if (currentPage > 1) {
            SoundsController.getInstance().play(Sounds.SFX.FLIPPAGE);
            currentPage--;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return LAST_PAGE;
    }

}