package com.aor.CrossingGuardJoe;

import com.aor.CrossingGuardJoe.gui.LanternaGUI;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.states.State;

import java.io.IOException;

public class Game {
    private LanternaGUI gui;
    private State state;

    public Game() throws IOException {
        gui = new LanternaGUI(1000, 500);
        //missing state
        run();
    }

    private void run() {
        Road road = new Road(1000, 500);
        road.createRoad();
    }
}
