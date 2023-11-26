package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.game.elements.CarController;
import com.aor.CrossingGuardJoe.controller.game.elements.JoeController;
import com.aor.CrossingGuardJoe.controller.game.elements.KidController;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class RoadController extends GameController {
    private final JoeController joeController;
    private final KidController kidController;
    private final CarController carController;

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
