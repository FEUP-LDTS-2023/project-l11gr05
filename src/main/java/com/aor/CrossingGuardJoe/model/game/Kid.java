package com.aor.CrossingGuardJoe.model.game;

public class Kid extends Element {
    private boolean walk;

    public Kid(int x, int y) {
        super(x, y);
    }

    public boolean canWalk() { return walk; }
}
