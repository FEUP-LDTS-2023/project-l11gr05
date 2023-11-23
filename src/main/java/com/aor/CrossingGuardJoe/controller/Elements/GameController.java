package com.aor.CrossingGuardJoe.controller.Elements;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }

}
