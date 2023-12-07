package com.CrossingGuardJoe.ControllerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.controller.game.elements.KidController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class KidControllerTest {
    private KidController kidController;
    private Road road;
    private Kid kid;
    private Joe joe;
    private Car car;

    @BeforeEach
    void setUp() {
        road = new Road();
        kid = mock(Kid.class);
        joe = mock(Joe.class);
        car = mock(Car.class);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        List<Kid> kids = new ArrayList<>();
        kids.add(kid);
        road.setJoe(joe);
        road.setCars(cars);
        road.setKids(kids);
        kidController = new KidController(road);
    }

    @Test
    public void nextActionTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(430, 330);
        when(kid.getPosition()).thenReturn(initialPosition);
        when(joe.getPosition()).thenReturn(new Position(414, 297));
        when(car.getPosition()).thenReturn(new Position(400, 200));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        verify(kid, times(1)).setSelected();
        verify(kid, times(1)).setWalking();
    }
}
