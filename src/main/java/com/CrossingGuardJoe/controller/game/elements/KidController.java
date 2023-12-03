package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.AuxCheckRange;
import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
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
    private static final int KID_STEP = 3;
    private static final double KID_SPEED = 0.005;
    private static final int MIN_KID_DISTANCE = 9;
    private static final int PASS_POINT = 60;
    private static final int MAX_Y_DISTANCE = 500;
    private static final int Y_AFTER_HIT = 55;
    private static final int INITIAL_POSITION = 430;
    private long lastUpdateTime;
    private Kid selectedKid;
    private final Joe joe = getModel().getJoe();
    private final List<Kid> sentKids = new ArrayList<>();

    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - KID_STEP, kid.getPosition().getY()), 'p');
    }

    public void moveKidAfterHit(Car car, Kid kid, int hitX, Iterator<Kid> kidIterator) {
        if (kid.getPosition().getY() > MAX_Y_DISTANCE) {
            kidIterator.remove();
        }
        kid.setPosition(new Position(hitX, car.getPosition().getY() + Y_AFTER_HIT));
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

    private boolean isFirstKid(Kid kid) {
        List<Kid> kids = getModel().getKids();
        return kids.indexOf(kid) == 0;
    }

    private boolean inMinDistance(Kid kid) {
        List<Kid> kids = getModel().getKids();
        if (!isFirstKid(kid)) {
            Kid kidInFront = kids.get(kids.indexOf(kid) - 1);
            return kid.getPosition().getX() - kidInFront.getPosition().getX() <= MIN_KID_DISTANCE;
        }
        return false;
    }

    private boolean canContinueWalk(Kid kid) {
        if (!isFirstKid(kid) && inMinDistance(kid)) {
            stopKid(kid);
            return false;
        }
        return true;
    }

    private void repositionQueue(Kid sentKid) {
        List<Kid> kids = getModel().getKids();
        int sentKidIndex = kids.indexOf(sentKid);
        Kid kidInFront = kids.get(sentKidIndex);
        for (int i = sentKidIndex + 1; i < kids.size(); i++) {
            Kid kid = kids.get(i);
            boolean shouldStop = kid.getPosition().getX() - kidInFront.getPosition().getX() <= MIN_KID_DISTANCE;
            /*while (kid.getPosition().getX() > INITIAL_POSITION && !shouldStop) {
                kid.isWalking();
                moveKid(kid);
            }
            kid.isNotWalking();
            kid.setPosition(new Position(kid.getPosition().getX(), kid.getPosition().getY()));
            stopKid(kid);*/
            if (kid.getPosition().getX() <= INITIAL_POSITION && shouldStop) {
                kid.isNotWalking();
                kid.setPosition(new Position(kid.getPosition().getX(), kid.getPosition().getY()));
                stopKid(kid);
            } else {
                kid.isWalking();
                kid.setPosition(new Position(kid.getPosition().getX() - KID_STEP, kid.getPosition().getY()));
            }
            kidInFront = kid;
        }
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
            //repositionQueue(selectedKid);
            if (selectedKid.isSelected() && !sentKids.contains(selectedKid)) {
                sentKids.add(selectedKid);
            }
        }

        if (action == GUI.ACTION.UP && joeInRange && selectedKid.getPosition().getX() > PASS_POINT) {
            selectedKid.isNotWalking();
        }

        if (time - lastUpdateTime > KID_SPEED) {
            for (Kid kid : kids) {
                if (sentKids.contains(kid)) {
                    if (kid.getIsWalkingState()) {
                        if (canContinueWalk(kid)) {
                            moveKid(kid);
                        } else if (isInRangeJoeKid(joe, kid) && joe.getIsRaisingStopSign()) {
                            stopKid(kid);
                        }
                    } else {
                        stopKid(kid);
                    }
                }
            }
            lastUpdateTime = time;
        }

        checkCollisions();
        checkPoints();
        checkLoss(); //temporary implemented
    }

    private void checkCollisions() {
        List<Car> cars = getModel().getCars();
        List<Kid> kids = getModel().getKids();
        int hitX;

        Iterator<Kid> kidIterator = kids.iterator();
        while (kidIterator.hasNext()) {
            Kid kid = kidIterator.next();
            for (Car car : cars) {
                if (isInRangeCarKid(car, kid)) {
                    hitX = kid.getPosition().getX();
                    kid.isHit();
                    kid.isNotWalking();
                    checkDeathCount(kid);
                    moveKidAfterHit(car, kid, hitX, kidIterator);
                }
            }
        }
    }

    private void checkDeathCount(Kid kid) {
        if (!kid.getDeathCounted()) {
            joe.removeHeart();
            kid.setDead();
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

    private void checkLoss() {
        if (joe.getHearts() == 0) {
            //temporary
            System.out.println("loss");
        }
    }
}

