package com.CrossingGuardJoe.viewer;

import com.CrossingGuardJoe.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clearScreen();
        drawElements(gui);
        gui.refreshScreen();
    }

    protected abstract void drawElements(GUI gui);
}
