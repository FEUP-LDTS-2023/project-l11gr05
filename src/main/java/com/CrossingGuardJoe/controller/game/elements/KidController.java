package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.controller.game.Sounds;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.Game;

import java.util.*;

import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeCarKid;
import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeJoeKid;
import static com.CrossingGuardJoe.controller.game.Sounds.playRandomSound;

public class KidController extends GameController {
    private static final int KID_STEP = 3;
    private static final double KID_SPEED = 0.005;
    private static final int MIN_KID_DISTANCE = 9;
    private static final int PASS_POINT = 80;
    private static final int MIN_Y_DISTANCE = 0;
    private static final int MAX_Y_DISTANCE = 500;
    private static final int Y_AFTER_HIT = 55;
    private long lastUpdateTime;
    private final Joe joe = getModel().getJoe();
    private Kid selectedKid;
    private final List<Kid> sentKids = new ArrayList<>();
    private int nextKidToMoveInQueueIndex;
    private boolean kidMovedInQueue = false;
    private int countKidsToNextLevel = 0;
    private final Sounds kidWalk1, kidStop1, kidStop2, kidHit, carBreak;

    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
        kidWalk1 = new Sounds("sounds/kid/KIDWALK1.wav");
        //kidWalk2 = new Sounds("sounds/kid/KIDWALK2.wav");
        kidStop1 = new Sounds("sounds/kid/KIDSTOP1.wav");
        kidStop2 = new Sounds("sounds/kid/KIDSTOP2.wav");
        kidHit = new Sounds("sounds/kid/KIDHIT.wav");
        carBreak = new Sounds("sounds/car/CARBREAK.wav");
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - KID_STEP, kid.getPosition().getY()), 'p');
    }

    public void moveKidAfterHit(Car car, Kid kid, int hitX) {
        kid.setPosition(new Position(hitX, car.getPosition().getY() + Y_AFTER_HIT));
    }

    public void stopKid(Kid kid) {
        KidAction(kid, kid.getPosition(), 's');
    }

    public void KidAction(Kid kid, Position position, char passOrStop) {
        if (passOrStop == 'p') {
            kid.setWalking();
            kid.setPosition(position);
        } else if (passOrStop == 's') {
            kid.setNotWalking();
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
            if (!kidInFront.getIsHit()) {
                return kid.getPosition().getX() - kidInFront.getPosition().getX() <= MIN_KID_DISTANCE + 1;
            }
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

    private void repositionQueue() {
        List<Kid> kids = getModel().getKids();

        for (int i = nextKidToMoveInQueueIndex; i < kids.size(); i++) {
            Kid kidToMoveInQueue = kids.get(i);
            int movesLeft = kidToMoveInQueue.getMovesInQueueLeft();

            if (movesLeft > 0) {
                if (canContinueWalk(kidToMoveInQueue)) {
                    moveKid(kidToMoveInQueue);
                    kidMovedInQueue = true;
                }
                if (kidMovedInQueue) {
                    kidToMoveInQueue.addMovesInQueueLeft(-1);
                    kidMovedInQueue = false;
                }
            } else {
                stopKid(kidToMoveInQueue);
                nextKidToMoveInQueueIndex++;
            }
        }
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) {
        List<Kid> kids = getModel().getKids();

        boolean joeInRange = false;

        for (Kid kid : kids) {
            if (isInRangeJoeKid(joe, kid) && kid.getPosition().getX() > PASS_POINT) {
                joeInRange = true;
                selectedKid = kid;
            }
            kid.setNotSelected();
        }

        if (joeInRange) {
            selectedKid.setSelected();
        }

        if (action == GUI.ACTION.DOWN && joeInRange && !selectedKid.getIsHit()) {
            selectedKid.setWalking();
            kidWalk1.play();
            if (!sentKids.contains(selectedKid)) {
                sentKids.add(selectedKid);
                nextKidToMoveInQueueIndex = kids.indexOf(selectedKid) + 1;

                for (int i = nextKidToMoveInQueueIndex; i < kids.size(); i++) {
                    Kid kid = kids.get(i);
                    stopKid(kid);
                    kid.addMovesInQueueLeft(3);
                }
            }
        }

        if (action == GUI.ACTION.UP && joeInRange) {
            selectedKid.setNotWalking();
            playRandomSound(kidStop1, kidStop2);
        }

        if (time - lastUpdateTime > KID_SPEED && !kids.isEmpty()) {
            repositionQueue();
            for (Kid kid : sentKids) {
                if (kid.getWalkingState() && canContinueWalk(kid)) {
                    moveKid(kid);
                }
                if (isInRangeJoeKid(joe, kid) && joe.getIsRaisingStopSign() && kid.getPosition().getX() > PASS_POINT + 10) {
                    stopKid(kid);
                }
            }
            lastUpdateTime = time;
        }

        checkCollisions();
        checkPoints();
        checkLoss(); //temporary implemented
        checkCountToNextLevel();
        checkLevelUp();
    }

    private void checkCollisions() {
        List<Car> cars = getModel().getCars();
        List<Kid> kids = getModel().getKids();
        int hitX;

        for (Kid kid : kids) {
            for (Car car : cars) {
                if (isInRangeCarKid(car, kid)) {
                    hitX = kid.getPosition().getX();
                    kid.isHit();
                    kid.setNotWalking();
                    checkDeathCount(kid);
                    moveKidAfterHit(car, kid, hitX);
                }
            }
        }
    }

    private void checkDeathCount(Kid kid) {
        if (!kid.getDeathCounted()) {
            carBreak.play();
            kidHit.play();
            joe.removeHeart();
            kid.setDead();
        }
    }

    private void checkPoints() {
        for (Kid kid : getModel().getKids()) {
            if (kid.getPosition().getX() < MIN_Y_DISTANCE && !kid.getPass()) {
                joe.addScore(kid.getPoints());
                kid.setPass();
            }
        }
    }

    private void checkLoss() {
        if (joe.getHearts() == 0) {

            //temporary
            System.out.println("loss");
        }
    }

    private void checkCountToNextLevel() {
        for (Kid kid : getModel().getKids()) {
            if (!kid.getCounted()) {
                if (kid.getPass() || (kid.getDeathCounted() && kid.getPosition().getY() >= MAX_Y_DISTANCE)) {
                    countKidsToNextLevel++;
                    kid.setCountToNextLevel();
                }
            }
        }
    }

    private int nextLevelNumberKids() {
        int currentLevel = getModel().getCurrentLevel();
        return switch (currentLevel) {
            case 2 -> 4;
            case 3 -> 5;
            case 4 -> 6;
            case 5 -> 7;
            case 6 -> 8;
            case 7 -> 9;
            case 8 -> 10;
            case 9 -> 11;
            case 10 -> 12;
            default -> 0;
        };
    }

    private void checkLevelUp() {
        if (countKidsToNextLevel == getModel().getKids().size()) {
            countKidsToNextLevel = 0;
            sentKids.clear();
            System.out.println("level pass");
            getModel().levelUp();
            getModel().setKidsNextLevel(nextLevelNumberKids());
        }
    }
}

