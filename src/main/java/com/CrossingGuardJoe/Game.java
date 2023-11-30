package com.CrossingGuardJoe;

import com.CrossingGuardJoe.gui.LanternaGUI;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.MenuState;
import com.CrossingGuardJoe.states.State;

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
        int FPS = 40;
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
        gui.clearScreen();
    }


    public void end() throws IOException {
        gui.closeScreen();
        System.exit(0);
    }
}
