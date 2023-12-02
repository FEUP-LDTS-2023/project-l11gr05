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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeCarKid;
import static com.CrossingGuardJoe.controller.game.AuxCheckRange.isInRangeJoeKid;

public class KidController extends GameController {
    private static final double KID_SPEED = 0.005;
    private long lastUpdateTime;
    private boolean walking = false;
    private Kid selectedKid;
    private Joe joe = getModel().getJoe();
    private List<Kid> outKids = new ArrayList<>();


    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - 3, kid.getPosition().getY()), 'p');
    }

    public void moveKidsToBegin(List<Kid> kids) {
        while (kids.get(0).getPosition().getX() > 430) {
            for (Kid kid : kids) {
                moveKid(kid);
            }
        }
    }

    public void moveKidAfterHit(Car car, Kid kid, int hitX, Iterator<Kid> kidIterator) {
        if (kid.getPosition().getY() > 500) {
            kidIterator.remove();
            getModel().getJoe().removeHeart();
        }
        kid.setPosition(new Position(hitX, car.getPosition().getY() + 55));
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
    public void nextAction(Game game, GUI.ACTION action, long time) {
        List<Kid> kids = getModel().getKids();
        //moveKidsToBegin(kids);

        boolean joeInRange = false;

        for (Kid kid : kids) {
            if (isInRangeJoeKid(getModel().getJoe(), kid)) {
                joeInRange = true;
                selectedKid = kid;
            }
            kid.setNotSelected();
        }

        if (joeInRange) {
            selectedKid.setSelected();
        }

        if (action == GUI.ACTION.DOWN && !walking && joeInRange && joe.getIsPassSign()) {
            walking = true;
        }

        if (walking && time - lastUpdateTime > KID_SPEED) {
            moveKid(selectedKid);
            lastUpdateTime = time;
        }

        if (action == GUI.ACTION.UP && joeInRange && selectedKid.getPosition().getX() > 60) {
            walking = false;
            stopKid(selectedKid);
        }

        checkCollisions();
        checkPoints();
        //checkWin(game); // temporary
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
                    walking = false;
                    moveKidAfterHit(car, kid, hitX, kidIterator);
                }
            }
        }
    }

    //temporary function
    public void checkWin(Game game) throws IOException {
        List<Kid> kids = getModel().getKids();

        for (Kid kid : kids) {
            if (!kid.getIsHit() && kid.getPosition().getX() <= 0) {
                System.out.println("You win!");
                game.end();
            }
        }
    }

    private void checkPoints() {
        Iterator<Kid> kidIterator = getModel().getKids().iterator();
        while (kidIterator.hasNext()) {
            Kid kid = kidIterator.next();
            if (kid.getPosition().getX() <= 0) {
                getModel().getJoe().addScore(kid.getPoints());
                kidIterator.remove();
            }
        }
    }
}

