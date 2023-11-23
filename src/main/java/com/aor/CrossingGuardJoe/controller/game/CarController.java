package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class CarController extends GameController {
    public CarController(Road road) {
        super(road);
    }

    public void moveCar(Car car, Position position) {
        /*Position position = new Position(getCar().getPosition().getX(), getCar().getPosition().getY() + 5 );
        car.setPosition(position);*/
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
