package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Car;
import com.aor.CrossingGuardJoe.model.game.Road;

public class CarController extends GameController {
    public CarController(Road road) {
        super(road);
    }

    public void moveCar(Car car, Position position) {
        /*Position position = new Position(getCar().getPosition().getX(), getCar().getPosition().getY() + 5 );
        car.setPosition(position);*/
    }
}
