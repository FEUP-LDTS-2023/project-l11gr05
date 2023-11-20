package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.game.KidView;
import com.googlecode.lanterna.input.KeyStroke;

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
