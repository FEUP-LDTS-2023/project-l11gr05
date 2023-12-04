package com.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private boolean walking = false;
    private boolean hit = false;
    private boolean selected = false;
    private boolean firstHalfOfMovement = true;
    private boolean deathCount = false;
    private boolean pass = false;
    private static final int POINTS = 100;
    private boolean countToNextLevel = false;
    private int movesInQueueLeft = 0;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void setWalking() {
        walking = true;
    }

    public void setNotWalking() {
        this.walking = false;
        this.firstHalfOfMovement = true;
    }

    public boolean getWalkingState() {
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

    public void addMovesInQueueLeft(int x) {
        this.movesInQueueLeft += x;
    }

    public int getMovesInQueueLeft() {
        return this.movesInQueueLeft;
    }

    public void setPass() {
        this.pass = true;
    }

    public boolean getPass() {
        return this.pass;
    }

    public void setCountToNextLevel() {
        this.countToNextLevel = true;
    }

    public boolean getCounted() {
        return this.countToNextLevel;
    }

    public int getPoints() {
        return POINTS;
    }
}
