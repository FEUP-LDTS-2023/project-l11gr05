package com.aor.CrossingGuardJoe.controller.Elements;

import com.aor.CrossingGuardJoe.Model.Position;
import com.aor.CrossingGuardJoe.Model.game.Kid;

public class KidController {
    private Kid kid;

    public KidController(Kid kid) {
        this.kid = kid;
    }

    public void move() {
        Position position = new Position(kid.getPosition().getX() - 5, kid.getPosition().getY());
        kid.setPosition(position);
    }
}
