package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.game.Road;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }

}
