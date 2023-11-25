package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class JoeController extends GameController {
    private GUI.ACTION lastAction = GUI.ACTION.NONE;

    public JoeController(Road road) {
        super(road);
    }

    public void moveJoeLeft() {
        JoeAction(new Position(
                        getModel().getJoe().getPosition().getX() - 6, getModel().getJoe().getPosition().getY()),
                'l');
    }

    public void moveJoeRight() {
        JoeAction(new Position(
                        getModel().getJoe().getPosition().getX() + 6, getModel().getJoe().getPosition().getY()),
                'r');
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
        if (passOrStop == 'l') {
            getModel().getJoe().isWalkingToLeft();
            getModel().getJoe().setPosition(position);
        }
        if (passOrStop == 'r') {
            getModel().getJoe().isWalkingToRight();
            getModel().getJoe().setPosition(position);
        }
        getModel().getJoe().setFirstHalfOfMovement(true);
    }
    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        //this one, joe will stop walking if the key direction is different
        if (action == GUI.ACTION.LEFT && lastAction == GUI.ACTION.RIGHT || action == GUI.ACTION.RIGHT && lastAction == GUI.ACTION.LEFT) {
            lastAction = GUI.ACTION.NONE;
        }

        //this one, joe will stop walking of any key input
        /*if ((action == GUI.ACTION.LEFT || action == GUI.ACTION.RIGHT) && (lastAction == GUI.ACTION.LEFT || lastAction == GUI.ACTION.RIGHT)) {
            lastAction = GUI.ACTION.NONE;
        }*/

        else if (!action.equals(lastAction) && action != GUI.ACTION.NONE) {
            lastAction = action;
        }
        if (lastAction == GUI.ACTION.LEFT) moveJoeLeft();
        if (lastAction == GUI.ACTION.RIGHT) moveJoeRight();
        if (lastAction == GUI.ACTION.UP) joeStopSign();
        if (lastAction == GUI.ACTION.DOWN) joePassSign();
        if (lastAction == GUI.ACTION.NONE) getModel().getJoe().isNotWalking();
    }
}
