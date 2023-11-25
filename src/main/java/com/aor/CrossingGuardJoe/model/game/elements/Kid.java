package com.aor.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private boolean walking;

    private boolean firstHalfOfMovement = true;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void isWalking() {
        walking = true;
        firstHalfOfMovement = true;
    }

    public void isNotWalking() {
        walking = false;
    }

    public boolean getIsWalkingState() {
        return this.walking;
    }

    public boolean isFirstHalfOfMovement() {
        return this.firstHalfOfMovement;
    }

    public void setFirstHalfOfMovement(boolean firstHalfOfMovement) {
        this.firstHalfOfMovement = firstHalfOfMovement;
    }
}
