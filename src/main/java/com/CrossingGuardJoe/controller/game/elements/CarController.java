package com.CrossingGuardJoe.controller.game.elements;

import com.CrossingGuardJoe.controller.game.GameController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.Game;

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
    public void nextAction(Game game, GUI.ACTION action, long time) {
        if (time - lastUpdateTime > CAR_SPEED) {
            for (Car car : getModel().getCars()) {
                moveCar(car, car.getPosition());
            }
            lastUpdateTime = time;
        }
    }
}
