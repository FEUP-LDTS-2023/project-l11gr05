package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.awt.event.KeyListener;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }

}
