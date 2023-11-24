package com.aor.CrossingGuardJoe.model.game.elements;

public class Joe extends Element{
    private boolean walking = false;
    private boolean isWalkingToLeft = true;  //only valid if 'walking' is true;
    private boolean raisingStopSign = false;
    private boolean passSign = false;

    //to make the joe's walking animation: change image frame between joe walking and joe standing
    private int walkFrame = 0;

    public Joe(int x, int y) {
        super(x, y);
    }

    public void isWalkingToLeft() {
        walking = true;
        isWalkingToLeft = true;
        raisingStopSign = false;
        passSign = false;

        walkFrame = (walkFrame + 1) % 2;
    }

    public void isWalkingToRight() {
        walking = true;
        isWalkingToLeft = false;
        raisingStopSign = false;
        passSign = false;

        walkFrame = (walkFrame + 1) % 2;
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

        walkFrame = 0;
    }

    public void passSign() {
        passSign = true;
        walking = false;
        raisingStopSign = false;

        walkFrame = 0;
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

    public int getWalkFrame() {
        return this.walkFrame;
    }
}
