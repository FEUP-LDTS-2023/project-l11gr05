package com.aor.CrossingGuardJoe;

import java.io.IOException;

public class Game {
    private Display display;

    public Game() {
    }

    private void init() throws IOException {
        int width = 1000; // Define your width and height
        int height = 500;
        display = new Display(width, height);
        display.init(); // Initialize the display
    }

    public void run() throws IOException {
        try {
            init();
        } catch (IOException e) {
            System.out.println("ERROR DETECTED: " + e.getMessage());
        }

    }
}
