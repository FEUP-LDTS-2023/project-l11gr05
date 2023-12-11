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

import static org.junit.jupiter.api.Assertions.*;
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
    public void inMinDistanceTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(300, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        assertTrue(kidController.isFirstKid(kid1));
        assertFalse(kidController.inMinDistance(kid1));
        assertFalse(kidController.isFirstKid(kid2));
        assertFalse(kidController.inMinDistance(kid2));
        assertTrue(kidController.inMinDistance(kid3));
    }

    @Test
    public void canContinueWalkTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(300, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        assertTrue(kidController.isFirstKid(kid1));
        assertFalse(kidController.isFirstKid(kid2));
        assertFalse(kidController.isFirstKid(kid3));
        assertTrue(kidController.canContinueWalk(kid2));
        assertFalse(kidController.canContinueWalk(kid3));
        assertFalse(kid3.getWalkingState());
    }

    @Test
    public void repositionQueueTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(427, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(kid1.getMovesInQueueLeft()).thenReturn(0);
        when(kid2.getMovesInQueueLeft()).thenReturn(3);
        when(kid3.getMovesInQueueLeft()).thenReturn(3);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        kidController.repositionQueue();
        assertTrue(kidController.canContinueWalk(kid2));
        assertFalse(kidController.canContinueWalk(kid3));
    }

    @Test
    public void checkPointsTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(-3, 330);
        Position kid2Position = new Position(0, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(kid1.getPoints()).thenReturn(100);
        when(kid2.getPoints()).thenReturn(100);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        kidController.checkPoints();
        verify(kid1, atLeastOnce()).setPass();
        verify(joe, atLeastOnce()).addScore(kid1.getPoints());
        verify(kid2, times(0)).setPass();
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
    public void checkCountToNextLevel() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(-3, 330);
        Position kid2Position = new Position(300, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(joe.getPosition()).thenReturn(new Position(100, 297));
        when(car.getPosition()).thenReturn(new Position(300, 330));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        kidController.checkCountToNextLevel();
        kid1.setPass();
        verify(kid1, atLeastOnce()).getPass();
        verify(kid2, atLeastOnce()).getDeathCounted();
        assertFalse(kid2.getPosition().getY() >= 500);
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
        when(kid1.getWalkingState()).thenReturn(true);
        when(joe.getPosition()).thenReturn(new Position(414, 297));
        when(car.getPosition()).thenReturn(new Position(100, 200));
        kidController.nextAction(null, GUI.ACTION.DOWN, initialTime);
        verify(kid1, atLeastOnce()).setSelected();
        verify(kid1, atLeastOnce()).setWalking();
        kidController.moveKid(kid1);
        verify(kid1, atLeastOnce()).setPosition(any());

        long nextTime = initialTime + 20000;
        kidController.nextAction(null, GUI.ACTION.NONE, nextTime);
        verify(kid3, atLeastOnce()).setNotWalking();
    }

    @Test
    public void stopKidWhenNearJoeTest() {
        long initialTime = System.currentTimeMillis();
        Position initialPosition = new Position(316, 330);
        Position kid2Position = new Position(439, 330);
        Position kid3Position = new Position(448, 330);
        when(kid1.getPosition()).thenReturn(initialPosition);
        when(kid2.getPosition()).thenReturn(kid2Position);
        when(kid3.getPosition()).thenReturn(kid3Position);
        when(kid1.getWalkingState()).thenReturn(true);
        when(joe.getIsRaisingStopSign()).thenReturn(true);
        when(joe.getPosition()).thenReturn(new Position(300, 297));
        when(car.getPosition()).thenReturn(new Position(100, 200));
        kidController.nextAction(null, GUI.ACTION.UP, initialTime);
        verify(kid1, atLeastOnce()).setNotWalking();
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
        when(joe.getPosition()).thenReturn(new Position(396, 297));
        when(car.getPosition()).thenReturn(new Position(200, 330));

        long nextTime = initialTime + (long) (1 / KID_SPEED + 1);
        kid1.setWalking();
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
        verify(joe, atLeastOnce()).removeHeart();
    }

    @Test
    public void nextLevelNumberKidsTest() {
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
        assertEquals(4, kidController.nextLevelNumberKids(2));
        assertEquals(5, kidController.nextLevelNumberKids(3));
        assertEquals(6, kidController.nextLevelNumberKids(4));
        assertEquals(7, kidController.nextLevelNumberKids(5));
        assertEquals(8, kidController.nextLevelNumberKids(6));
        assertEquals(9, kidController.nextLevelNumberKids(7));
        assertEquals(10, kidController.nextLevelNumberKids(8));
        assertEquals(11, kidController.nextLevelNumberKids(9));
        assertEquals(12, kidController.nextLevelNumberKids(0));
    }
}
