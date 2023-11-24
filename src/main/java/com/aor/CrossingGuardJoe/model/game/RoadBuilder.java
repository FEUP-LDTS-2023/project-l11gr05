package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;

import java.util.List;

public abstract class RoadBuilder {
    public Road createRoad() {
        Road road = new Road(getWidth(), getHeight());

        road.setJoe(createJoe());
        //road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Joe createJoe();

    protected abstract List<Car> createCars();
    //missing all others elements creater
}
