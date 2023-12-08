package com.CrossingGuardJoe.ControllerTest.game.elements;

import com.CrossingGuardJoe.controller.game.elements.JoeController;
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
    private JoeController joeController;
    private Road road;
    private Kid kid1, kid2, kid3;
    private Joe joe;
    private Car car;
    private static final double KID_SPEED = 0.005;

    @BeforeEach
    void setUp() {
        road = new Road();
        kid1 = mock(Kid.class);
        kid2 = mock(Kid.class);
        kid3 = mock(Kid.class);
        joe = mock(Joe.class);
        car = mock(Car.class);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        List<Kid> kids = new ArrayList<>();
        kids.add(kid1);
        kids.add(kid2);
        kids.add(kid3);
        road.setJoe(joe);
        road.setCars(cars);
        road.setKids(kids);
        kidController = new KidController(road);
        joeController = mock(JoeController.class);
    }

    @Test
    public void kidPassTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(100, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        verify(kid1, atLeastOnce()).getPass();
    }

    @Test
    public void kidWalkTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(430, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(414, 297));
        when(car.getPosition()).thenReturn(new Position(100, 200));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        verify(kid1, atLeastOnce()).setSelected();
        verify(kid1, atLeastOnce()).setWalking();

        long nextTime = initialTime + 20000;
        kidController.nextAction(null, GUI.ACTION.NONE, nextTime);
        verify(kid3, atLeastOnce()).setNotWalking();
    }

    @Test
    public void kidStopTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(400, 330);
        Position kid2Position = new Position(412, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(390, 297));
        when(car.getPosition()).thenReturn(new Position(200, 330));

        long nextTime = initialTime + (long) (1 / KID_SPEED + 1);
        kidController.nextAction(null, GUI.ACTION.UP, nextTime);
        verify(kid1, atLeastOnce()).setNotWalking();

        kidController.moveKid(kid2);
        verify(kid2, atLeastOnce()).setWalking();
        kidController.moveKid(kid2);
        kidController.moveKid(kid2);
        kidController.moveKid(kid2);
        verify(kid2, atLeastOnce()).setNotWalking();
    }

    @Test
    public void kidHitByCarTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(200, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(414, 297));
        when(car.getPosition()).thenReturn(new Position(200, 330));
        kidController.nextAction(null, GUI.ACTION.LEFT, initialTime);
        verify(kid1, atLeastOnce()).isHit();
        verify(kid1, atLeastOnce()).setDead();
    }

    @Test
    public void kidStopNearJoeTest() {
        long initialTime = System.currentTimeMillis();
        kid1.setWalking();
        Position kid1Position = new Position(103, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(kid1Position);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        joe.setPosition(new Position(100, 297));
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(400, 100));
        joeController.nextAction(null, GUI.ACTION.UP, initialTime);
        kidController.nextAction(null, GUI.ACTION.UP, initialTime);
        //verify(joe, atLeastOnce()).startRaisingStopSign();
        //verify(kid1, atLeastOnce()).setNotWalking();
    }
}
