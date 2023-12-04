package com.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private boolean walking = false;
    private boolean hit = false;
    private boolean selected = false;
    private boolean firstHalfOfMovement = true;
    private boolean deathCount = false;
    private static final int POINTS = 100;
    private int movesLeft = 0;
    private boolean lastSent = false;
    private boolean isSent = false;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void isWalking() {
        walking = true;
    }

    public void isNotWalking() {
        this.walking = false;
        this.firstHalfOfMovement = true;
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
        this.hit = true;
        this.selected = false;
    }

    public boolean getIsHit() { return this.hit;}

    public void setDead() {
        this.deathCount = true;
    }

    public boolean getDeathCounted() {
        return this.deathCount;
    }

    public void addMovesLeft(int x) {
        this.movesLeft += x;
    }

    public int getMovesLeft() {
        return this.movesLeft;
    }

    public int getPoints() {
        return POINTS;
    }
}
