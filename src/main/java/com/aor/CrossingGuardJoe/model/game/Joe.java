package com.aor.CrossingGuardJoe.model.game;

public class Joe extends Element{
    private boolean isWalking = false;
    private boolean directionToLeft = false;

    public Joe(int x, int y) {
        super(x, y);
    }

    public void setWalking(boolean isWalking) {
        this.isWalking = isWalking;
    }

    public void setWalkingDirectionToLeft() {
        directionToLeft = true;
    }
    public void setWalkingDirectionToRight() {
        directionToLeft = false;
    }
    public boolean getIsWalking() {
        return this.isWalking;
    }
    public boolean getDWalkingDirectionIsLeft() {
        return this.directionToLeft;
    }
}
