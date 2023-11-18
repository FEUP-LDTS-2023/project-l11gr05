package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.Position;

public class Kid extends Element {
    public Kid(int x, int y) {
        super(x, y);
    }

    public void moveLeft() {
        Position position = new Position(getPosition().getX() - 3, getPosition().getY());
        setPosition(position);
    }

    public void moveRight() {
        Position position = new Position(getPosition().getX() + 3, getPosition().getY());
        setPosition(position);
    }
}
