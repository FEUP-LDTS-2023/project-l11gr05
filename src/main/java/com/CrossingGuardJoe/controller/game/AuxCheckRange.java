package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

public class AuxCheckRange {
    private static final int JOE_AT_KID_RIGHT = 9;
    private static final int JOE_AT_KID_LEFT = 21;
    private static final int KID_AT_CAR_LEFT = 10;
    private static final int KID_AT_CAR_RIGHT = 52;
    private static final int CAR_FRONT = 15;
    private static final int CAR_REAR = 65;
    private static final int CAR_MIDDLE = 21;
    private static final int JOE_AT_CAR_LEFTSIDE = 18;
    private static final int JOE_AT_CAR_RIGHTSIDE = 52;

    public static boolean isInRangeJoeKid(Joe joe, Kid kid) {
        return joe.getPosition().getX() <= kid.getPosition().getX() + JOE_AT_KID_RIGHT &&
                joe.getPosition().getX() >= kid.getPosition().getX() - JOE_AT_KID_LEFT;
    }

    public static boolean isInRangeCarKid(Car car, Kid kid) {
        return car.getPosition().getX() <= kid.getPosition().getX() + KID_AT_CAR_LEFT &&
                car.getPosition().getX() >= kid.getPosition().getX() - KID_AT_CAR_RIGHT &&
                car.getPosition().getY() <= kid.getPosition().getY() + CAR_FRONT &&
                car.getPosition().getY() >= kid.getPosition().getY() - CAR_REAR;
    }

    public static boolean isInRangeLeftCarJoe(Car car, Joe joe) {
        return car.getPosition().getX() <= joe.getPosition().getX() + CAR_MIDDLE &&
                car.getPosition().getX() >= joe.getPosition().getX() - JOE_AT_CAR_LEFTSIDE &&
                car.getPosition().getY() <= joe.getPosition().getY() + CAR_FRONT &&
                car.getPosition().getY() >= joe.getPosition().getY() - CAR_REAR;
    }

    public static boolean isInRangeRightCarJoe(Car car, Joe joe) {
        return car.getPosition().getX() < joe.getPosition().getX() + CAR_MIDDLE &&
                car.getPosition().getX() >= joe.getPosition().getX() - JOE_AT_CAR_RIGHTSIDE &&
                car.getPosition().getY() <= joe.getPosition().getY() + CAR_FRONT &&
                car.getPosition().getY() >= joe.getPosition().getY() - CAR_REAR;
    }
}
