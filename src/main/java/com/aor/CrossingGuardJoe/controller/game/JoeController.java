package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class JoeController extends GameController {

    public JoeController(Road road) {
        super(road);
    }

    public void moveJoeLeft() {
        JoeAction(new Position(
                getModel().getJoe().getPosition().getX() - 5, getModel().getJoe().getPosition().getY()),
                'l');

    }

    public void moveJoeRight() {
        JoeAction(new Position(
                        getModel().getJoe().getPosition().getX() + 5, getModel().getJoe().getPosition().getY()),
                'r');
    }

    public void joePassSign() {
        JoeAction(getModel().getJoe().getPosition(), 'p');
    }

    public void joeStopSign() {
        JoeAction(getModel().getJoe().getPosition(), 's');
    }

    private Position walkToLeftInertia() {
        return new Position(getModel().getJoe().getPosition().getX() - 5, getModel().getJoe().getPosition().getY());
    }

    public void JoeAction(Position position, char passOrStop) {
        if (passOrStop == 'p') {
            getModel().getJoe().passSign();
        }
        if (passOrStop == 's') {
            getModel().getJoe().isRaisingStopSign();
        }
        if (passOrStop == 'l') {
            getModel().getJoe().isWalkingToLeft();
            getModel().getJoe().setPosition(position);
            //getModel().getJoe().isNotWalking();
            //getModel().getJoe().setPosition(walkToLeftInertia());
        }
        if (passOrStop == 'r') {
            getModel().getJoe().isWalkingToRight();
            getModel().getJoe().setPosition(position);
        }
    }
    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveJoeLeft();
        if (action == GUI.ACTION.RIGHT) moveJoeRight();

        if (action == GUI.ACTION.UP) joeStopSign();
        if (action == GUI.ACTION.DOWN) joePassSign();
    }
}
