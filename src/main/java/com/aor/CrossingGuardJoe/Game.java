package com.aor.CrossingGuardJoe;

import com.aor.CrossingGuardJoe.gui.LanternaGUI;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.states.GameState;
import com.aor.CrossingGuardJoe.states.MenuState;
import com.aor.CrossingGuardJoe.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI(1000, 500);
        state = new MenuState(new Menu());
        //state = new GameState(new LoaderRoadBuilder().createRoad());
        //missing state
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().run();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void run() throws IOException {
        //i think manipulating that values can improve the lag problem
        int FPS = 10;
        int frameTime = 100 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }

    public void end() {
        //add method to close screen
    }
}
