package com.CrossingGuardJoe.model.game.elements;

public class Joe extends Element{
    private boolean walking = false;
    private boolean isWalkingToLeft = true;  //only valid if 'walking' is true;
    private boolean raisingStopSign = false;
    private boolean passSign = false;

    //to make the joe's walking animation: change image frame between joe walking and joe standing
    private boolean firstHalfOfMovement = true;

    public Joe(int x, int y) {
        super(x, y);
    }

    public void isWalkingToLeft() {
        walking = true;
        isWalkingToLeft = true;
        raisingStopSign = false;
        passSign = false;

        firstHalfOfMovement = true;
    }

    public void isWalkingToRight() {
        walking = true;
        isWalkingToLeft = false;
        raisingStopSign = false;
        passSign = false;

        firstHalfOfMovement = true;
    }

    public void isNotWalking() {
        walking = false;
        raisingStopSign = false;
        passSign = false;
    }

    public void isRaisingStopSign() {
        raisingStopSign = true;
        walking = false;
        passSign = false;
    }

    public void passSign() {
        passSign = true;
        walking = false;
        raisingStopSign = false;
    }

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
