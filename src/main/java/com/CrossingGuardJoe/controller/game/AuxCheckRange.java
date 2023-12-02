package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

public class AuxCheckRange {
    public static boolean isInRangeJoeKid(Joe joe, Kid kid) {
        //1st x joe in rightside of kid, 2nd x joe in lefside of kid
        return joe.getPosition().getX() <= kid.getPosition().getX() + 9 &&
                joe.getPosition().getX() >= kid.getPosition().getX() - 20;
    }

    public static boolean isInRangeCarKid(Car car, Kid kid) {
        //1st x is leftside 2nd x is rightside
        return car.getPosition().getX() <= kid.getPosition().getX() + 10 &&
                car.getPosition().getX() >= kid.getPosition().getX() - 52 &&
                car.getPosition().getY() <= kid.getPosition().getY() + 15 &&
                car.getPosition().getY() >= kid.getPosition().getY() - 65;
    }

    public static boolean isInRangeLeftCarJoe(Car car, Joe joe) {
        return car.getPosition().getX() <= joe.getPosition().getX() + 21 &&
                car.getPosition().getX() >= joe.getPosition().getX() - 18 &&
                car.getPosition().getY() <= joe.getPosition().getY() + 15 &&
                car.getPosition().getY() >= joe.getPosition().getY() - 65;
    }

    public static boolean isInRangeRightCarJoe(Car car, Joe joe) {
        return car.getPosition().getX() <= joe.getPosition().getX() + 21 &&
                car.getPosition().getX() >= joe.getPosition().getX() - 52 &&
                car.getPosition().getY() <= joe.getPosition().getY() + 15 &&
                car.getPosition().getY() >= joe.getPosition().getY() - 65;
    }
}
