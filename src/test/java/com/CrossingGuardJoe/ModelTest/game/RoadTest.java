package com.CrossingGuardJoe.ModelTest.game;

import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    @Test
    public void testIsGameEnded() {
        Road road = new Road();
        assertFalse(road.isGameEnded());

        for (int i = 0; i < 8; i++) {
            road.levelUp();
            assertFalse(road.isGameEnded());
        }

        // Level up to 10, game should end
        road.levelUp();
        assertTrue(road.isGameEnded());
    }

    @Test
    public void testGetCurrentLevel() {
        Road road = new Road();
        assertEquals(1, road.getCurrentLevel());

        // Level up to 5
        for (int i = 1; i <= 4; i++) {
            road.levelUp();
        }
        assertEquals(5, road.getCurrentLevel());
        assertNotEquals(10, road.getCurrentLevel());
        assertFalse(road.isGameEnded());

        // Level up to 10
        for (int i = 5; i <= 9; i++) {
            road.levelUp();
        }
        assertEquals(10, road.getCurrentLevel());
        assertTrue(road.isGameEnded());
    }

    @Test
    public void testSetJoe() {
        Road road = new Road();
        Joe joe = new Joe(0, 0);
        road.setJoe(joe);
        assertEquals(joe, road.getJoe());
    }

    @Test
    public void testSetKids() {
        Road road = new Road();
        List<Kid> kids = new ArrayList<>();
        kids.add(new Kid(0, 0));
        road.setKids(kids);
        assertEquals(kids, road.getKids());
    }

    @Test
    public void testSetCars() {
        Road road = new Road();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0, 0));
        road.setCars(cars);
        assertEquals(cars, road.getCars());
    }

    @Test
    public void testSetKidsNextLevel() {
        Road road = new Road();
        int numberKids = 5;
        road.setKidsNextLevel(numberKids);
        assertEquals(numberKids, road.getKids().size());
    }
}
