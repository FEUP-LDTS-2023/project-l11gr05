package com.CrossingGuardJoe.ControllerTest;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarControllerTest {
    @Test
    void testMoveCar() {
        Road road = new Road();
        CarController carController = new CarController(road);
        int initialX = 10;
        int initialY = 20;
        Car car = new Car(initialX, initialY);

        carController.moveCar(car, car.getPosition()); // Move the car

        int expectedX = initialX;
        int expectedY = initialY + 15;

        Position expectedPosition = new Position(expectedX, expectedY);
        Position actualPosition = car.getPosition();

        assertEquals(expectedPosition.getX(), actualPosition.getX());
        assertEquals(expectedPosition.getY(), actualPosition.getY());
    }


}
