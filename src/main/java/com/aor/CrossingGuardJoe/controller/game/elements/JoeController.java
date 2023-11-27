package com.aor.CrossingGuardJoe.controller.game.elements;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.game.GameController;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class JoeController extends GameController {
    private GUI.ACTION lastAction = GUI.ACTION.NONE;

    public JoeController(Road road) {
        super(road);
    }

    private void moveJoe(int x, char direction) {
        Position newPosition = new Position(getModel().getJoe().getPosition().getX() + x,
                getModel().getJoe().getPosition().getY());

        if (canGoThrough(newPosition)) {
            JoeAction(newPosition, direction);
        } else {
            setLastActionNone();
            joeNotWalking();
        }
    }

    public void moveJoeLeft() {
        moveJoe(-6, 'l');
    }

    public void moveJoeRight() {
        moveJoe(6, 'r');
    }


    public void joePassSign() {
        JoeAction(getModel().getJoe().getPosition(), 'p');
    }

    public void joeStopSign() {
        JoeAction(getModel().getJoe().getPosition(), 's');
    }

    public void JoeAction(Position position, char passOrStop) {
        switch (passOrStop) {
            case 'p':
                getModel().getJoe().passSign();
                break;
            case 's':
                getModel().getJoe().isRaisingStopSign();
                break;
            case 'l':
                getModel().getJoe().isWalkingToLeft();
                getModel().getJoe().setPosition(position);
                break;
            case 'r':
                getModel().getJoe().isWalkingToRight();
                getModel().getJoe().setPosition(position);
                break;
        }
    }

    public void joeNotWalking() {
        getModel().getJoe().isNotWalking();
    }

    private boolean canGoThrough(Position position) {
        return (position.getX() >= 50 && position.getX() <= 420);
    }

    private void setLastActionNone() {
        this.lastAction = GUI.ACTION.NONE;
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        //this one, joe will stop walking if the key direction is different
        if (action == GUI.ACTION.LEFT && lastAction == GUI.ACTION.RIGHT || action == GUI.ACTION.RIGHT && lastAction == GUI.ACTION.LEFT) {
            setLastActionNone();
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
        if (lastAction == GUI.ACTION.NONE) joeNotWalking();
    }
}
