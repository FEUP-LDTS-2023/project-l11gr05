package com.aor.CrossingGuardJoe.controller;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public abstract void nextAction(Game game, GUI.ACTION action, long time) throws IOException;
}
