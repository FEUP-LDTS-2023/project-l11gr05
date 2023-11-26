package com.aor.CrossingGuardJoe.ControllerTest;

import com.aor.CrossingGuardJoe.controller.game.elements.CarController;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
