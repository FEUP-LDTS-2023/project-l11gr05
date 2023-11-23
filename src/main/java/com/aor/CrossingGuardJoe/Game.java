package com.aor.CrossingGuardJoe;

import com.aor.CrossingGuardJoe.gui.LanternaGUI;
import com.aor.CrossingGuardJoe.model.game.LoaderRoadBuilder;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.states.GameState;
import com.aor.CrossingGuardJoe.states.MenuState;
import com.aor.CrossingGuardJoe.states.State;

import java.io.IOException;

public class Game {
    private LanternaGUI gui;
    private State state;

    public Game() throws IOException {
        gui = new LanternaGUI(1000, 500);
        state = new GameState(new LoaderRoadBuilder().createRoad());
        //missing state
        run();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void run() throws IOException {
        long startTime = System.currentTimeMillis();
        state.action(this, gui, startTime);
    }
}
