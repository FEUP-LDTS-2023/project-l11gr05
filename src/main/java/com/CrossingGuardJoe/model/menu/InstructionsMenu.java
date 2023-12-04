package com.CrossingGuardJoe.model.menu;

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
        }
    }

    @Override
    public void navigateLeft() {
        if (currentPage > 1) {
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