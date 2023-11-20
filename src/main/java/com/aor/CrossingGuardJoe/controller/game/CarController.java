package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Car;
import com.aor.CrossingGuardJoe.model.game.Kid;

public class CarController {
    private Car car;

    public CarController(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return this.car;
    }

    public void move() {
        Position position = new Position(getCar().getPosition().getX(), getCar().getPosition().getY() + 5 );
        car.setPosition(position);
    }
}
