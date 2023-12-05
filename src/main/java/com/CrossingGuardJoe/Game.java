package com.CrossingGuardJoe;

import com.CrossingGuardJoe.gui.LanternaGUI;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.MenuState;
import com.CrossingGuardJoe.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Stack;

public class Game {
    private LanternaGUI gui;
    private Stack<State> stateStack;
    private int highestScore = 0;
    private int highestLevel = 0;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI(1000, 500);
        stateStack = new Stack<>();
        stateStack.push(new MenuState(new Menu()));
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().run();
    }

    public void setState(State state) {
        this.stateStack.push(state);
    }

    public void popState() {
        if (!stateStack.isEmpty()) {
            stateStack.pop();
        }
    }

    public State getCurrentState() {
        if (!stateStack.isEmpty()){
            return stateStack.peek();
        }
        return null;
    }

    private void run() throws IOException {
        //i think manipulating that values can improve the lag problem
        int FPS = 100;
        int frameTime = 100 / FPS;

        while (getCurrentState() != null) {
            long startTime = System.currentTimeMillis();
            getCurrentState().step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.closeScreen();
    }

    public void end() throws IOException {
        gui.closeScreen();
        System.exit(0);
    }

    public int getHighestScore() {
        return highestScore;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public void setHighestLevel(int highestLevel) {
        this.highestLevel = highestLevel;
    }
}
