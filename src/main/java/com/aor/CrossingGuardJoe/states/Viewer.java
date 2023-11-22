package com.aor.CrossingGuardJoe.states;

public class Viewer<T> {
    private T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }
}
