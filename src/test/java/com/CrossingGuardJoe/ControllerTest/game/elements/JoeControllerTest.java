package com.CrossingGuardJoe.ControllerTest.game.elements;


import static org.mockito.Mockito.*;

import com.CrossingGuardJoe.controller.game.RoadController;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.RoadBuilder;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class JoeControllerTest {
    private JoeController joeController;
    private Road road;
    private Joe joe;
    private Car car;

    @BeforeEach
    void setUp() {
        road = new Road();
        joe = Mockito.mock(Joe.class);
        road.setJoe(joe);
        car = Mockito.mock(Car.class);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        road.setCars(cars);
        joeController = new JoeController(road);
    }


    @Test
    void nextActionTest() {
        Position initialPosition = new Position(390, 297);
        joe.setPosition(initialPosition);
        when(joe.getPosition()).thenReturn(initialPosition);
        when(car.getPosition()).thenReturn(new Position(400, 297));

        // Test action NONE
        joeController.nextAction(null, GUI.ACTION.NONE, 0);
        verify(joeController.getModel().getJoe(), times(1)).stopWalking();

        // Test action UP
        joeController.nextAction(null, GUI.ACTION.UP, 0);
        verify(joeController.getModel().getJoe(), times(1)).startRaisingStopSign();

        // Test action DOWN
        joeController.nextAction(null, GUI.ACTION.DOWN, 0);
        verify(joeController.getModel().getJoe(), times(1)).startRaisingPassSign();

        // Test action LEFT
        joeController.nextAction(null, GUI.ACTION.LEFT, 0);
        verify(joeController.getModel().getJoe(), times(1)).startWalkingToLeft();
        verify(joeController.getModel().getJoe(), atLeastOnce()).setPosition(any());

        when(car.getPosition()).thenReturn(new Position(350, 297));
        joe.setPosition(initialPosition);
        // Test action RIGHT
        joeController.nextAction(null, GUI.ACTION.RIGHT, 0);
        verify(joe, times(1)).startWalkingToRight();
        verify(joe, atLeastOnce()).setPosition(any());
    }

    @Test
    public void cannotGoThrough() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(54, 297);
        joe.setPosition(initialPosition);
        when(joe.getPosition()).thenReturn(initialPosition);;
        when(car.getPosition()).thenReturn(new Position(400, 297));
        joeController.nextAction(null, GUI.ACTION.LEFT, initialTime);
    }

    @Test
    public void cancelMove() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(200, 297);
        joe.setPosition(initialPosition);
        when(joe.getPosition()).thenReturn(initialPosition);;
        when(car.getPosition()).thenReturn(new Position(400, 297));
        joeController.nextAction(null, GUI.ACTION.LEFT, initialTime);
        joeController.nextAction(null, GUI.ACTION.RIGHT, initialTime);
    }
}
