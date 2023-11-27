package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Element;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }

    public boolean isInRangeJoeKid(Joe joe, Kid kid) {
        return joe.getPosition().getX() <= kid.getPosition().getX() + 8 &&
                joe.getPosition().getX() >= kid.getPosition().getX() - 28;
    }

    public boolean isInRangeCarKid(Car car, Kid kid) {
        //1st x is leftside 2nd x is rightside
        return car.getPosition().getX() <= kid.getPosition().getX() + 10 &&
                car.getPosition().getX() >= kid.getPosition().getX() - 40 &&
                car.getPosition().getY() <= kid.getPosition().getY() + 100 &&
                car.getPosition().getY() >= kid.getPosition().getY() - 65;
    }

    public boolean isInRange(Element element1, Element element2) {
        return element1.getPosition().getX() <= element2.getPosition().getX() + 8 &&
                element1.getPosition().getX() >= element2.getPosition().getX() - 28;
    }
}
