package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }

    public abstract Controller<T> getController();

    public abstract Viewer<T> getViewer();

    public T getModel() {
        return this.model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION keyaction = gui.getNextAction();
        controller.nextAction(game, keyaction, time);
        viewer.draw(gui);
    }
}
