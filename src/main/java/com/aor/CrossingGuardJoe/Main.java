package com.aor.CrossingGuardJoe;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            Game game = new Game();
            game.run();
        } catch (IOException e) {
            System.out.println("ERROR DETECTED: " + e.getMessage());
        }


    }
}