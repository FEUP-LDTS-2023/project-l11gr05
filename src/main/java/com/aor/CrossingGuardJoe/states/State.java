package com.aor.CrossingGuardJoe.states;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.viewer.Viewer;

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

    public void action(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.nextAction(game, action, time);
        viewer.draw(gui);
    }
}
