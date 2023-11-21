package com.aor.CrossingGuardJoe.model.game;

public class Kid extends Element {
    private boolean isWalking = false;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void setWalking(boolean isWalking) {
        this.isWalking = isWalking;
    }
    public boolean getIsWalking() {
        return this.isWalking;
    }
}
