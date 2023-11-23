package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.model.game.Road;

public class RoadController extends GameController{
    private final JoeController joeController;
    private final KidController kidController;
    private final CarController carController;

    public RoadController(Road road) {
        super(road);

        this.joeController = new JoeController(road);
        this.kidController = new KidController(road);
        this.carController = new CarController(road);
    }
}
