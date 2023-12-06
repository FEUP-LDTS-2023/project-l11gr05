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
        int newY = 50;
        int minDistance = 20;

        // Create a list of cars with one car at position 60
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0, 60));

        // Test when there is an overlapping car
        assertTrue(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));

        // Test when there is no overlapping car
        newY = 80;
        assertFalse(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));

        // Test when the list of cars is empty
        cars.clear();
        assertFalse(AuxCarCheck.isAnyCarOverlapping(newY, cars, minDistance));
    }
}
