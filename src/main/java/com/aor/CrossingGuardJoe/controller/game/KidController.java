package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Element;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;
import com.aor.CrossingGuardJoe.model.game.elements.Kid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KidController extends GameController{

    private static final double KID_SPEED = 0.005;
    private long lastUpdateTime;
    private boolean walkInitiated = false;

    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - 3, kid.getPosition().getY()), 'p');
    }

    public void stopKid(Kid kid) {
        KidAction(kid, kid.getPosition(), 's');
    }

    public void KidAction(Kid kid, Position position, char passOrStop) {
        if (passOrStop == 'p') {
            kid.isWalking();
            kid.setPosition(position);
        } else if (passOrStop == 's') {
            kid.isNotWalking();
        }
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (isInRange(getModel().getJoe(), getModel().getKids())) {
            getModel().getKids().setSelected();
        }
        else {
            getModel().getKids().setNotSelected();
        }
        if (action == GUI.ACTION.DOWN && !walkInitiated &&
        isInRange(getModel().getJoe(), getModel().getKids())) {
            walkInitiated = true;
        }
        if (walkInitiated && time - lastUpdateTime > KID_SPEED) {
            moveKid();
            lastUpdateTime = time;
        }
        if (action == GUI.ACTION.UP && isInRange(getModel().getJoe(), getModel().getKids())) {
            walkInitiated = false;
            stopKid();
        }
    }
}

