package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;

import java.util.List;

import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeLeftCarJoe;
import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeRightCarJoe;


public class JoeController extends GameController {
    private GUI.ACTION lastAction = GUI.ACTION.NONE;
    private static final int JOE_MIN_X_DISTANCE = 50;
    private static final int JOE_MAX_X_DISTANCE = 414;
    private static final int JOE_STEP = 6;
    private static final int JOE_AFTER_HIT = 10;

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
        moveJoe(-JOE_STEP, 'l');
    }

    public void moveJoeRight() {
        moveJoe(JOE_STEP, 'r');
    }

    public void moveJoeLeftHit() {
        setLastActionNone();
        Joe joe = getModel().getJoe();
        joe.setPosition(new Position(joe.getPosition().getX() - JOE_AFTER_HIT, joe.getPosition().getY()));
        joe.countHitPoints();
        SoundsController.getInstance().play(Sounds.SFX.JOEHIT);
    }

    public void moveJoeRightHit() {
        setLastActionNone();
        Joe joe = getModel().getJoe();
        joe.setPosition(new Position(joe.getPosition().getX() + JOE_AFTER_HIT, joe.getPosition().getY()));
        joe.countHitPoints();
        SoundsController.getInstance().play(Sounds.SFX.JOEHIT);
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
                getModel().getJoe().startRaisingPassSign();
                break;
            case 's':
                getModel().getJoe().startRaisingStopSign();
                break;
            case 'l':
                getModel().getJoe().setPosition(position);
                getModel().getJoe().startWalkingToLeft();
                break;
            case 'r':
                getModel().getJoe().setPosition(position);
                getModel().getJoe().startWalkingToRight();
                break;
        }
    }

    public void joeNotWalking() {
        getModel().getJoe().stopWalking();
    }

    private boolean canGoThrough(Position position) {
        return (position.getX() >= JOE_MIN_X_DISTANCE && position.getX() <= JOE_MAX_X_DISTANCE);
    }

    private void setLastActionNone() {
        this.lastAction = GUI.ACTION.NONE;
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) {
        if ((action == GUI.ACTION.LEFT && lastAction == GUI.ACTION.RIGHT) || (action == GUI.ACTION.RIGHT && lastAction == GUI.ACTION.LEFT)) {
            setLastActionNone();
        }

        else if (!action.equals(lastAction) && action != GUI.ACTION.NONE) {
            if (action == GUI.ACTION.DOWN) {
                SoundsController.playRandom(Sounds.SFX.JOEPASS1, Sounds.SFX.JOEPASS2);
            } else if (action == GUI.ACTION.UP) {
                SoundsController.getInstance().play(Sounds.SFX.JOESTOP);
            }
            lastAction = action;
        }

        if (lastAction == GUI.ACTION.LEFT) moveJoeLeft();
        if (lastAction == GUI.ACTION.RIGHT) moveJoeRight();
        if (lastAction == GUI.ACTION.UP) joeStopSign();
        if (lastAction == GUI.ACTION.DOWN) joePassSign();
        if (lastAction == GUI.ACTION.NONE) joeNotWalking();

        checkCollisions();
    }

    public void checkCollisions(){
        List<Car> cars = getModel().getCars();
        Joe joe = getModel().getJoe();

        for (Car car : cars) {
            if (isInRangeLeftCarJoe(car, joe)) {
                joe.isHitLeft();
                moveJoeLeftHit();
            } else if (isInRangeRightCarJoe(car, joe)) {
                joe.isHitRight();
                moveJoeRightHit();
            }
        }
    }
}
