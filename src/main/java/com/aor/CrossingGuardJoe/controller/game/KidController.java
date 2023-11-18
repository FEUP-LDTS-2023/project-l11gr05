package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.game.KidView;
import com.googlecode.lanterna.input.KeyStroke;

public class KidController {
    private Kid kid;
    private KidView kidview;

    public KidController(Kid kid, KidView kidview) {
        this.kid = kid;
        this.kidview = kidview;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowLeft:
                kid.moveLeft();
                break;
            case ArrowRight:
                kid.moveRight();
        }
    }
}
