package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;

public abstract class RoadBuilder {
    public Road createRoad() {
        Road road = new Road(getWidth(), getHeight());

        road.setJoe(new Joe(100,100));
        //road.setKids(createKids());
        //road.setCars(createCars());

        return road;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Joe createJoe();

    //missing all others elements creater
}
