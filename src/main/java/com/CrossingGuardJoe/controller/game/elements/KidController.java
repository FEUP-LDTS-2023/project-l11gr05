package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.AuxCheckRange;
import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Command;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.model.game.elements.KidCommand.KidStopCommand;
import com.CrossingGuardJoe.model.game.elements.KidCommand.KidWalkCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeCarKid;
import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeJoeKid;

public class KidController extends GameController {
    private Command command;
    private static final int KID_STEP = 3;
    private static final double KID_SPEED = 0.005;
    private static final int KID_DISTANCE = 10;
    private static final int PASS_POINT = 60;
    private static final int MAX_Y_DISTANCE = 500;
    private static final int Y_AFTER_HIT = 55;
    private long lastUpdateTime;
    private Kid selectedKid;
    private final Joe joe = getModel().getJoe();
    private List<Kid> outKids = new ArrayList<>();

    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - KID_STEP, kid.getPosition().getY()), 'p');
        repositionQueue(kid);
    }

    private void repositionQueue(Kid sentKid) {
        List<Kid> kids = getModel().getKids();
        int sentKidIndex = kids.indexOf(sentKid);

        for (int i = sentKidIndex + 1; i < kids.size(); i++) {
            Kid kid = kids.get(i);
            kid.setPosition(new Position(kid.getPosition().getX() - KID_DISTANCE, kid.getPosition().getY()));
        }
    }

    public void moveKidAfterHit(Car car, Kid kid, int hitX, Iterator<Kid> kidIterator) {
        if (kid.getPosition().getY() > MAX_Y_DISTANCE) {
            kidIterator.remove();
            joe.removeHeart();
        }
        kid.setPosition(new Position(hitX, car.getPosition().getY() + Y_AFTER_HIT));
    }

    public void stopKid(Kid kid) {
        KidAction(kid, kid.getPosition(), 's');
    }

    public void KidAction(Kid kid, Position position, char passOrStop) {
        if (passOrStop == 'p') {
            this.command = new KidWalkCommand(kid);
            kid.setPosition(position);
        } else if (passOrStop == 's') {
            this.command = new KidStopCommand(kid);
        }
        kid.setAndExecuteCommand(command);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) {
        List<Kid> kids = getModel().getKids();

        boolean joeInRange = false;

        for (Kid kid : kids) {
            if (isInRangeJoeKid(joe, kid)) {
                joeInRange = true;
                selectedKid = kid;
            }
            kid.setNotSelected();
        }

        if (joeInRange) {
            selectedKid.setSelected();
        }

        if (action == GUI.ACTION.DOWN && joeInRange) {
            selectedKid.isWalking();
            outKids.add(selectedKid);
        }

        if (action == GUI.ACTION.UP && joeInRange && selectedKid.getPosition().getX() > PASS_POINT) {
            selectedKid.isNotWalking();
        }

        if (time - lastUpdateTime > KID_SPEED) {
            for (Kid kid : outKids) {
                if (kid.getIsWalkingState()) {
                    moveKid(kid);
                } else {
                    stopKid(kid);
                }
            }
            lastUpdateTime = time;
        }

        checkCollisions();
        checkPoints();
    }

    private void checkCollisions() {
        List<Car> cars = getModel().getCars();
        List<Kid> kids = getModel().getKids();

        Iterator<Kid> kidIterator = kids.iterator();
        while (kidIterator.hasNext()) {
            Kid kid = kidIterator.next();
            for (Car car : cars) {
                if (isInRangeCarKid(car, kid)) {
                    int hitX = kid.getPosition().getX();
                    kid.isHit();
                    kid.isNotWalking();
                    moveKidAfterHit(car, kid, hitX, kidIterator);
                }
            }
        }
    }

    private void checkPoints() {
        Iterator<Kid> kidIterator = getModel().getKids().iterator();
        while (kidIterator.hasNext()) {
            Kid kid = kidIterator.next();
            if (kid.getPosition().getX() < 0) {
                joe.addScore(kid.getPoints());
                kidIterator.remove();
            }
        }
    }
}

