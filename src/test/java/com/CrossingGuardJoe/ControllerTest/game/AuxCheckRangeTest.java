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

        assertTrue(AuxCheckRange.isInRangeJoeKid(joe, kid), "Joe should be in range of Kid");
    }

    @Test
    void testIsInRangeCarKid() {
        Car car = new Car(10, 20);
        Kid kid = new Kid(15, 25);

        assertTrue(AuxCheckRange.isInRangeCarKid(car, kid), "Car should be in range of Kid");
    }

    @Test
    void testIsInRangeLeftCarJoe() {
        Car car = new Car(10, 20);
        Joe joe = new Joe(15, 25);

        assertTrue(AuxCheckRange.isInRangeLeftCarJoe(car, joe), "Car should be in range of Joe on the left side");
    }

    @Test
    void testIsInRangeRightCarJoe() {
        Car car = new Car(30, 20);
        Joe joe = new Joe(25, 25);

        assertTrue(AuxCheckRange.isInRangeRightCarJoe(car, joe), "Car should be in range of Joe on the right side");
    }
}
