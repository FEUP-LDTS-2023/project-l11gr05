package com.aor.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private boolean walking;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void isWalking() {
        walking = true;
    }

    public void isNotWalking() {
        walking = false;
    }

    public boolean getIsWalkingState() {
        return this.walking;
    }
}
