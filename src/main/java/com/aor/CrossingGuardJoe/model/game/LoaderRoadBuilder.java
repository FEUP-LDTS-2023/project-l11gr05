package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;

import java.util.List;

public class LoaderRoadBuilder extends RoadBuilder{

    @Override
    protected int getWidth() {
        return 0;
    }

    @Override
    protected int getHeight() {
        return 0;
    }

    @Override
    protected Joe createJoe() {
        return new Joe(100,100);
    }

    @Override
    protected Car createCars() {
        return new Car(200, 100);
    }


}
