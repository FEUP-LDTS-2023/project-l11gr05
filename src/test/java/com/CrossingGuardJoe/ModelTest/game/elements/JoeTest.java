package com.CrossingGuardJoe.ModelTest.game.elements;

import com.CrossingGuardJoe.model.game.elements.Joe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JoeTest {
    @Test
    public void testInitialScoreAndHearts() {
        Joe joe = new Joe(0, 0);
        assertEquals(0, joe.getScore());
        assertEquals(10, joe.getHearts());
    }

    @Test
    public void testAddScore() {
        Joe joe = new Joe(0, 0);
        joe.addScore(100);
        assertEquals(100, joe.getScore());
    }

    @Test
    public void testRemoveHeart() {
        Joe joe = new Joe(0, 0);
        joe.removeHeart();
        assertEquals(9, joe.getHearts());
        for (int i = 9; i >= 0; i--) {
            joe.removeHeart();
        }
        assertEquals(0, joe.getHearts());
    }

    @Test
    public void testStartWalkingToLeft() {
        Joe joe = new Joe(0, 0);
        joe.startWalkingToLeft();
        assertTrue(joe.getIsWalkingState());
        assertTrue(joe.getIsWalkingToLeft());
        assertFalse(joe.getIsRaisingStopSign());
        assertFalse(joe.getIsPassSign());
    }

    @Test
    public void testStartWalkingToRight() {
        Joe joe = new Joe(0, 0);
        joe.startWalkingToRight();
        assertTrue(joe.getIsWalkingState());
        assertFalse(joe.getIsWalkingToLeft());
        assertFalse(joe.getIsRaisingStopSign());
        assertFalse(joe.getIsPassSign());
    }

    @Test
    public void testStopWalking() {
        Joe joe = new Joe(0, 0);
        joe.stopWalking();
        assertFalse(joe.getIsWalkingState());
        assertFalse(joe.getIsRaisingStopSign());
        assertFalse(joe.getIsPassSign());
        assertTrue(joe.isFirstHalfOfMovement());
    }

    @Test
    public void testStartRaisingStopSign() {
        Joe joe = new Joe(0, 0);
        joe.startRaisingStopSign();
        assertFalse(joe.getIsWalkingState());
        assertTrue(joe.getIsRaisingStopSign());
        assertFalse(joe.getIsPassSign());
        assertTrue(joe.isFirstHalfOfMovement());
    }

    @Test
    public void testStartRaisingPassSign() {
        Joe joe = new Joe(0, 0);
        joe.startRaisingPassSign();
        assertFalse(joe.getIsWalkingState());
        assertFalse(joe.getIsRaisingStopSign());
        assertTrue(joe.getIsPassSign());
        assertTrue(joe.isFirstHalfOfMovement());
    }

    @Test
    public void testIsHitLeft() {
        Joe joe = new Joe(0, 0);
        joe.isHitLeft();
        assertTrue(joe.getIsHit());
        assertTrue(joe.getHitLeft());
    }

    @Test
    public void testIsHitRight() {
        Joe joe = new Joe(0, 0);
        joe.isHitRight();
        assertTrue(joe.getIsHit());
        assertFalse(joe.getHitLeft());
    }

    @Test
    public void testCountHitPoints() {
        Joe joe = new Joe(0, 0);
        joe.addScore(2);
        joe.countHitPoints();
        assertEquals(0, joe.getScore());
        joe.countHitPoints();
        assertEquals(0, joe.getScore());
    }

    @Test
    public void testNotHit() {
        Joe joe = new Joe(0, 0);
        joe.isNotHit();
        assertFalse(joe.getIsHit());
    }

    @Test
    public void testSetFirstHalfOfMovement() {
        Joe joe = new Joe(0, 0);

        assertTrue(joe.isFirstHalfOfMovement());
        
        joe.setFirstHalfOfMovement(false);
        assertFalse(joe.isFirstHalfOfMovement());

        joe.setFirstHalfOfMovement(true);
        assertTrue(joe.isFirstHalfOfMovement());
    }
}
