package com.CrossingGuardJoe.ControllerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarControllerTest {
    private CarController carController;
    private Road road;
    private Car car;
    private static final int CAR_STEP = 15;
    private static final double CAR_SPEED = 0.001;

    @BeforeEach
    void setUp() {
        road = new Road();
        car = Mockito.mock(Car.class);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        road.setCars(cars);
        carController = new CarController(road);
    }

    @Test
    void nextActionTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(0, 0);
        Mockito.when(car.getPosition()).thenReturn(initialPosition);
        carController.nextAction(null, GUI.ACTION.NONE, initialTime);

        long nextTime = initialTime + (long) (1 / CAR_SPEED + 1);
        carController.nextAction(null, GUI.ACTION.NONE, nextTime);
        Mockito.verify(car, Mockito.atLeastOnce()).setPosition(new Position(0, CAR_STEP));
    }
}
