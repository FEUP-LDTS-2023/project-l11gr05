package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.Road;

import java.io.IOException;

public class JoeController extends GameController{
    public JoeController(Road road) {
        super(road);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {

    }
}