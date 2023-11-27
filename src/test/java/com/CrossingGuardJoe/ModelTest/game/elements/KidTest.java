package com.CrossingGuardJoe.ModelTest.game.elements;

import com.CrossingGuardJoe.model.game.elements.Kid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KidTest {
    @Test
    void testKidInitialization() {
        Kid kid = new Kid(100, 200);

        assertEquals(100, kid.getPosition().getX());
        assertEquals(200, kid.getPosition().getY());
        assertFalse(kid.isSelected());
        assertFalse(kid.getIsWalkingState());
        assertFalse(kid.getIsHit());
    }

    @Test
    void testSetSelected() {
        Kid kid = new Kid(100, 200);

        assertFalse(kid.isSelected());
        kid.setSelected();
        assertTrue(kid.isSelected());
    }

    @Test
    void testSetNotSelected() {
        Kid kid = new Kid(100, 200);

        kid.setSelected();
        assertTrue(kid.isSelected());
        kid.setNotSelected();
        assertFalse(kid.isSelected());
    }

    @Test
    void testIsWalking() {
        Kid kid = new Kid(100, 200);

        assertFalse(kid.getIsWalkingState());
        kid.isWalking();
        assertTrue(kid.getIsWalkingState());
    }

    @Test
    void testIsNotWalking() {
        Kid kid = new Kid(100, 200);

        kid.isWalking();
        assertTrue(kid.getIsWalkingState());
        kid.isNotWalking();
        assertFalse(kid.getIsWalkingState());
    }

    @Test
    void testIsHit() {
        Kid kid = new Kid(100, 200);

        assertFalse(kid.getIsHit());
        kid.isHit();
        assertTrue(kid.getIsHit());
    }
}
