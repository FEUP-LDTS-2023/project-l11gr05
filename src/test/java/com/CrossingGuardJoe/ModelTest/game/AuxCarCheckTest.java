package com.CrossingGuardJoe.ModelTest.game;

import com.CrossingGuardJoe.model.game.AuxCarCheck;
import com.CrossingGuardJoe.model.game.elements.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuxCarCheckTest {

    @Test
    public void testIsAnyCarOverlapping() {
        int newY = 70;
        int minDistance = 20;

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0, 60));

        assertTrue(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));

        newY = 80;
        assertFalse(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));

        cars.clear();
        assertFalse(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));
    }
}
