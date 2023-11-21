package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.Position;

public abstract class ElementMover {
    private int velocity;
    private Position position;
    private boolean isAlive = true;

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }
}
