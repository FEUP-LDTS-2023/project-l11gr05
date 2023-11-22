package com.aor.CrossingGuardJoe.model.game;

public class Joe extends Element{
    private boolean walking;
    private boolean raisingStop;

    public Joe(int x, int y) {
        super(x, y);
    }

    public boolean isWalking() { return walking; }

    public boolean isRaisingStop() { return raisingStop; }

}
