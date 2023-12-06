package com.CrossingGuardJoe.ModelTest.game.elements;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.elements.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void testCarConstruction() {
        int x = 10;
        int y = 20;
        Car car = new Car(x, y);

        assertEquals(x, car.getPosition().getX());
        assertEquals(y, car.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        Car car = new Car(0, 0);
        Position newPosition = new Position(10, 10);
        car.setPosition(newPosition);

        assertEquals(10, car.getPosition().getX());
        assertEquals(10, car.getPosition().getY());
    }
}
