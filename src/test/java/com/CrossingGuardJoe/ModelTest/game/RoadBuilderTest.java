package com.CrossingGuardJoe.ModelTest.game;

import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.RoadBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RoadBuilderTest {
    @Test
    void createRoad() {
        RoadBuilder roadBuilder = new RoadBuilder();
        Road road = roadBuilder.createRoad();

        assertNotNull(road);
        assertNotNull(road.getJoe());
        assertNotNull(road.getKids());
        assertNotNull(road.getCars());
    }

}
