package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.Game;

import java.io.IOException;
import java.util.List;

public class KidController extends GameController {

    private static final double KID_SPEED = 0.005;
    private long lastUpdateTime;
    private boolean walkInitiated = false;
    private int currentKidIndex = 0;


    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - 7, kid.getPosition().getY()), 'p');
    }

    public void moveKidsToBegin(List<Kid> kids) {
        while (kids.get(0).getPosition().getX() > 430) {
            for (Kid kid : kids) {
                moveKid(kid);
            }
        }
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
        List<Kid> kids = getModel().getKids();
        moveKidsToBegin(kids);

        boolean joeInRange = false;
        for (Kid kid : kids) {
            if (isInRangeJoeKid(getModel().getJoe(), kid)) {
                joeInRange = true;
                kid.setSelected();
            } else {
                kid.setNotSelected();
            }
        }

        if (action == GUI.ACTION.DOWN && !walkInitiated && joeInRange) {
            walkInitiated = true;
        }

        if (walkInitiated && time - lastUpdateTime > KID_SPEED) {
            moveCurrentKid(kids);
            lastUpdateTime = time;
        }

        if (action == GUI.ACTION.UP && joeInRange) {
            walkInitiated = false;
            stopCurrentKid(kids);
        }

        checkCollisions(game);
        checkWin(game); // temporary
    }

    private void moveCurrentKid(List<Kid> kids) {
        if (currentKidIndex < kids.size()) {
            moveKid(kids.get(currentKidIndex));
            currentKidIndex++;
        } else {
            currentKidIndex = 0;
        }
    }

    private void stopCurrentKid(List<Kid> kids) {
        if (currentKidIndex < kids.size()) {
            stopKid(kids.get(currentKidIndex));
        } else {
            currentKidIndex = 0;
        }
    }

    public void checkCollisions(Game game) throws IOException {
        List<Car> cars = getModel().getCars();
        List<Kid> kids = getModel().getKids();

        for (Car car : cars) {
            for (Kid kid : kids) {
                if (isInRangeCarKid(car, kid)) {
                    kid.isHit();
                    System.out.println("Game Over - Car collided with a kid!");
                    game.end();
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
}

