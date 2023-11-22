package com.aor.CrossingGuardJoe.controller;

import java.io.IOException;

public abstract class Controller<T> {
    private T model;
    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    //public abstract void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException;
}
