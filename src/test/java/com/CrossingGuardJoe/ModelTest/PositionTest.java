package com.CrossingGuardJoe.ModelTest;

import com.CrossingGuardJoe.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(5, 10);
        assertEquals(10, position.getY());
    }

    @Test
    public void testSetX() {
        Position position = new Position(5, 10);
        position.setX(15);
        assertEquals(15, position.getX());
    }

    @Test
    public void testSetY() {
        Position position = new Position(5, 10);
        position.setY(20);
        assertEquals(20, position.getY());
    }

    @Test
    public void testEqualsSameObject() {
        Position position = new Position(5, 10);
        assertTrue(position.equals(position));
    }

    @Test
    public void testEqualsNullObject() {
        Position position = new Position(5, 10);
        assertFalse(position.equals(null));
    }

    @Test
    public void testEqualsDifferentClassObject() {
        Position position = new Position(5, 10);
        assertFalse(position.equals("This is not a Position object"));
    }

    @Test
    public void testEqualsEqualPositions() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        assertTrue(position1.equals(position2));
    }

    @Test
    public void testEqualsUnequalPositions() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(3, 8);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void testHashCodeEqualPositions() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void testHashCodeUnequalPositions() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(3, 8);
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }
}
