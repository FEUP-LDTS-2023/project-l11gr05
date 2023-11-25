package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class RoadController extends GameController {
    private final com.aor.CrossingGuardJoe.controller.game.JoeController joeController;
    private final com.aor.CrossingGuardJoe.controller.game.KidController kidController;
    private final com.aor.CrossingGuardJoe.controller.game.CarController carController;

    public RoadController(Road road) {
        super(road);

        this.joeController = new JoeController(road);
        this.kidController = new KidController(road);
        this.carController = new CarController(road);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        joeController.nextAction(game, action, time);
        kidController.nextAction(game, action, time);
        carController.nextAction(game, action, time);
    }
}
