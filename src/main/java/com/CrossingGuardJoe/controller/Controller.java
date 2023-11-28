package com.CrossingGuardJoe.controller;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.Game;

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
