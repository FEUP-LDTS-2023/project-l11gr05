package com.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private boolean walking = false;
    private boolean hit = false;
    private boolean selected = false;
    private boolean firstHalfOfMovement = true;
    private boolean dead = false;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void isWalking() {
        walking = true;
    }

    public void isNotWalking() {
        walking = false;
        firstHalfOfMovement = true;
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

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected() {
        this.selected = true;
    }

    public void setNotSelected() {
        this.selected = false;
    }

    public void isHit() {
        hit = true;
        selected = false;
        dead = true;
    }

    public boolean getIsHit() { return hit;}

    public int getPoints() {
        return 100;
    }
}
