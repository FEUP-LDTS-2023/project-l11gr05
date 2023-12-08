package com.CrossingGuardJoe.ControllerTest.game;

import com.CrossingGuardJoe.controller.game.AuxCheckRange;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuxCheckRangeTest {
    @Test
    void testIsInRangeJoeKid() {
        Joe joe = new Joe(10, 20);
        Kid kid = new Kid(15, 25);

        assertTrue(AuxCheckRange.isInRangeJoeKid(joe, kid));

        joe = new Joe(100, 20);
        kid = new Kid(15, 25);

        assertFalse(AuxCheckRange.isInRangeJoeKid(joe, kid));

        joe = new Joe(10, 20);
        kid = new Kid(150, 25);

        assertFalse(AuxCheckRange.isInRangeJoeKid(joe, kid));
    }

    @Test
    void testIsInRangeCarKid() {
        Car car = new Car(10, 20);
        Kid kid = new Kid(15, 25);

        assertTrue(AuxCheckRange.isInRangeCarKid(car, kid));

        car = new Car(100, 20);
        kid = new Kid(15, 25);

        assertFalse(AuxCheckRange.isInRangeCarKid(car, kid));
    }

    @Test
    void testIsInRangeLeftCarJoe() {
        Car car = new Car(10, 20);
        Joe joe = new Joe(15, 25);

        assertTrue(AuxCheckRange.isInRangeLeftCarJoe(car, joe));

        car = new Car(10, 20);
        joe = new Joe(150, 25);

        assertFalse(AuxCheckRange.isInRangeLeftCarJoe(car, joe));
    }

    @Test
    void testIsInRangeRightCarJoe() {
        Car car = new Car(30, 20);
        Joe joe = new Joe(25, 25);

        assertTrue(AuxCheckRange.isInRangeRightCarJoe(car, joe));

        car = new Car(300, 20);
        joe = new Joe(25, 25);

        assertFalse(AuxCheckRange.isInRangeRightCarJoe(car, joe));
    }
}
