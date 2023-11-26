package com.aor.CrossingGuardJoe.controller.game.elements;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.game.GameController;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Element;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;
import com.aor.CrossingGuardJoe.model.game.elements.Kid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KidController extends GameController {

    private static final double KID_SPEED = 0.005;
    private long lastUpdateTime;
    private boolean walkInitiated = false;

    public KidController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveKid(Kid kid) {
        KidAction(kid, new Position(kid.getPosition().getX() - 10, kid.getPosition().getY()), 'p');
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

    private int currentKidIndex = 0;

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        List<Kid> kids = getModel().getKids();

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
                    return;
                }
            }
        }
    }
}

