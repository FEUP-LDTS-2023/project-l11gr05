package com.CrossingGuardJoe.model.game.elements;

public class Joe extends Element{
    private int Score;
    private final int MAX_SCORE = 99999;
    private int Hearts;
    private final int MAX_HEARTS = 10;
    private boolean walking = false;
    private boolean isWalkingToLeft = true;
    private boolean raisingStopSign = false;
    private boolean passSign = false;
    private boolean firstHalfOfMovement = true;
    private boolean hit = false;
    private boolean hitLeft = true;

    public Joe(int x, int y) {
        super(x, y);
        this.Score = 2163;
        this.Hearts = 10;
    }

    public int getScore() {
        return this.Score;
    }

    public void addScore(int points) {
        this.Score += points;
    }

    public int getHearts() {
        return this.Hearts;
    }

    public void removeHeart() {
        this.Hearts--;
    }

    public void startWalkingToLeft() {
        walking = true;
        isWalkingToLeft = true;
        raisingStopSign = false;
        passSign = false;
    }

    public void startWalkingToRight() {
        walking = true;
        isWalkingToLeft = false;
        raisingStopSign = false;
        passSign = false;
    }

    public void stopWalking() {
        walking = false;
        raisingStopSign = false;
        passSign = false;
        firstHalfOfMovement = true;
    }

    public void startRaisingStopSign() {
        raisingStopSign = true;
        walking = false;
        passSign = false;
        firstHalfOfMovement = true;
    }

    public void startRaisingPassSign() {
        passSign = true;
        walking = false;
        raisingStopSign = false;
        firstHalfOfMovement = true;
    }

    public void isNotHit() {
        hit = false;
    }

    public void isHitLeft() {
        hit = true;
        hitLeft = true;
    }

    public void isHitRight() {
        hit = true;
        hitLeft = false;
    }

    public boolean getIsHit() { return this.hit; }

    public boolean getHitLeft() {return this.hitLeft;}

    public boolean getIsWalkingState() {
        return this.walking;
    }

    public boolean getIsWalkingToLeft() {
        return this.isWalkingToLeft;
    }

    public boolean getIsRaisingStopSign() {
        return this.raisingStopSign;
    }

    public boolean getIsPassSign() {
        return this.passSign;
    }

    public boolean isFirstHalfOfMovement() {
        return this.firstHalfOfMovement;
    }

    public void setFirstHalfOfMovement(boolean firstHalfOfMovement) {
        this.firstHalfOfMovement = firstHalfOfMovement;
    }
}
