package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class KidController extends GameController{

    public KidController(Road road) {
        super(road);
    }

    public void kidWalk() {

    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
