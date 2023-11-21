package com.aor.CrossingGuardJoe;

import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.game.KidView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class Display implements GUI {
    private Terminal terminal;
    private Screen screen;
    private TextGraphics textGraphics;

    private int width;
    private int height;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() throws IOException {

        terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height))
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.newInstance(new Font("Monospaced", Font.PLAIN, 1)))
                .createTerminal();

        screen = new TerminalScreen(terminal);
        screen.startScreen();
        //screen.doResizeIfNecessary(); // Resize screen if necessary

        KidView kidView = new KidView(textGraphics);
        kidView.setKid(new Kid(0,0));
        kidView.drawKidStand();


    }

    public void drawGame() {
        // Your drawing logic here
        // Example:
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
        textGraphics.putString(1, 1, "Hello, Crossing Guard Joe!");
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
        terminal.close();
    }


    @Override
    public void displayKid(Position position) {

    }

    @Override
    public void displayJoe(Position position) {

    }

    @Override
    public void displayCar(Position position) {

    }
}
