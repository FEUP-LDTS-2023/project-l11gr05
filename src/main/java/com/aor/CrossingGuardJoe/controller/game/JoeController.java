package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class JoeController extends GameController {
    private int getActualJoePositionX = getModel().getJoe().getPosition().getX();
    private int getActualJoePositionY = getModel().getJoe().getPosition().getX();

    public JoeController(Road road) {
        super(road);
    }

    public void moveJoeLeft() {
        JoeAction(new Position(getActualJoePositionX - 1, getActualJoePositionY), 'n');
    }

    public void moveJoeRight() {
        JoeAction(new Position(getActualJoePositionX + 1, getActualJoePositionY), 'n');
    }

    public void joePassSign() {
        JoeAction(getModel().getJoe().getPosition(), 'p');
    }

    public void joeStopSign() {
        JoeAction(getModel().getJoe().getPosition(), 's');
    }

    public void JoeAction(Position position, char passOrStop) {
        if (passOrStop == 'p') {
            getModel().getJoe().passSign();
        }

        if (passOrStop == 's') {
            getModel().getJoe().isRaisingStopSign();
        }
        if (passOrStop == 'n'){
            getModel().getJoe().isWalking();
            getModel().getJoe().setPosition(position);
        }
    }
    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveJoeLeft();
        if (action == GUI.ACTION.RIGHT) moveJoeRight();
        if (action == GUI.ACTION.PASS) joePassSign();
        if (action == GUI.ACTION.STOP) joeStopSign();
    }
}
