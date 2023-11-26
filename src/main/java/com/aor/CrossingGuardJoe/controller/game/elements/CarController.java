package com.aor.CrossingGuardJoe.controller.game.elements;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.game.GameController;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;

import java.io.IOException;

public class CarController extends GameController {
    private static final double CAR_SPEED = 0.001;
    private long lastUpdateTime;

    public CarController(Road road) {
        super(road);
        lastUpdateTime = System.currentTimeMillis();
    }

    public void moveCar(Car car, Position position) {
        car.setPosition(new Position(position.getX(), position.getY() + 15));
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastUpdateTime > CAR_SPEED) {
            for (Car car : getModel().getCars()) {
                moveCar(car, car.getPosition());
            }
            lastUpdateTime = time;
        }
    }
}
