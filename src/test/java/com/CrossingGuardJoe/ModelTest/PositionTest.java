package com.CrossingGuardJoe.ModelTest;
import com.CrossingGuardJoe.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {
    @Test
    public void testEquals() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        Position position3 = new Position(5, 6);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    public void testHashCode() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        Position position3 = new Position(5, 6);

        assertEquals(position1.hashCode(), position2.hashCode());
        assertNotEquals(position1.hashCode(), position3.hashCode());
    }

    @Test
    public void testGetX() {
        Position position = new Position(3, 4);
        assertEquals(3, position.getX());
    }

    @Test
    public void testSetX() {
        Position position = new Position(3, 4);
        position.setX(5);
        assertEquals(5, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(3, 4);
        assertEquals(4, position.getY());
    }

    @Test
    public void testSetY() {
        Position position = new Position(3, 4);
        position.setY(6);
        assertEquals(6, position.getY());
    }
}
