package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenu implements MenuNavigator {
    private final List<Option> pages;
    private int currentPage = 0;

    public InstructionsMenu() {
        this.pages = Arrays.asList(
                new Option("1", new Position(400, 400), null),
                new Option("2", new Position(400, 400), null)
        );
    }

    @Override
    public void navigateUp() {}

    @Override
    public void navigateDown() {}

    @Override
    public void navigateRight() {
        currentPage = (currentPage + 1) % pages.size();
    }

    @Override
    public void navigateLeft() {
        currentPage = (currentPage - 1) % pages.size();
    }

    public Option getCurrentPage() {
        return pages.get(currentPage);
    }

    public int getTotalPages() {
        return pages.size();
    }

    public boolean isLastPage() {
        return currentPage == pages.size() - 1;
    }
}