package com.aor.CrossingGuardJoe.model.game.elements;

public class Joe extends Element{
    private boolean walking = false;
    private boolean raisingStopSign = false;
    private boolean passSign = false;

    public Joe(int x, int y) {
        super(x, y);
    }

    public void isWalking() {
        walking = true;
        raisingStopSign = false;
        passSign = false;
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

}
