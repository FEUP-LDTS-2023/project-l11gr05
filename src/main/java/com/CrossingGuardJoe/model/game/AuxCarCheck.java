package com.CrossingGuardJoe.model.game;

import com.CrossingGuardJoe.model.game.elements.Car;

import java.util.List;

public class AuxCarCheck {
    private static boolean isCarOverlapping(int newY, int existingY, int minDistance) {
        return Math.abs(newY - existingY) < minDistance;
    }

    public static boolean isAnyCarOverlapping(int newY, List<Car> cars, int minDistance) {
        for (Car existingCar : cars) {
            if (isCarOverlapping(newY, existingCar.getPosition().getY(), minDistance)) {
                return true;
            }
        }
        return false;
    }
}
