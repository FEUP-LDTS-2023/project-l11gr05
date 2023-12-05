package com.CrossingGuardJoe.model.game.elements;

public class Joe extends Element{
    private int Score;
    private int Hearts;
    private static final int INITIAL_SCORE = 0;
    private static final int MAX_HEARTS = 10;
    private boolean walking = false;
    private boolean isWalkingToLeft = true;
    private boolean raisingStopSign = false;
    private boolean passSign = false;
    private boolean firstHalfOfMovement = true;
    private boolean hit = false;
    public static final int HITPOINTS = -2;
    private boolean hitLeft = true;

    public Joe(int x, int y) {
        super(x, y);
<<<<<<< HEAD
        this.Score = 0;
=======
        this.Score = INITIAL_SCORE;
>>>>>>> aca1e3d (added more sounds and refactored some code)
        this.Hearts = MAX_HEARTS;
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
        if (this.Hearts > 0) this.Hearts--;
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

    public void countHitPoints() {
        if (this.getScore() > 0) {
            addScore(HITPOINTS);
        }
    }
}
