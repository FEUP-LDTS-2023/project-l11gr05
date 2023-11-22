package com.aor.CrossingGuardJoe.gui;

import com.googlecode.lanterna.TerminalPosition;
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

public class LanternaGUI implements GUI{
    private TextGraphics graphics;
    private Screen screen;
    private TerminalSize terminalSize;
    private int width;
    private int height;
    
    public LanternaGUI(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        createTerminal();
        
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }

    public TerminalSize getTerminalSize() {
        return this.terminalSize;
    }
    private void createTerminal() throws IOException {
        this.terminalSize = new TerminalSize(getWidth(), getHeight());
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.newInstance(new Font("Monospaced", Font.PLAIN, 1)))
                .createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
        this.graphics = screen.newTextGraphics();

        setBackgroundColor("#7F7976");
        refreshScreen();
    }

    private void setBackgroundColor(String hexCode) {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString(hexCode));
        this.graphics.fillRectangle(new TerminalPosition(0,0), getTerminalSize(), ' ');
    }
    
    /*
    public LanternaGUI() throws IOException {
        this.terminalSize = new TerminalSize(1000, 500);
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.newInstance(new Font("Monospaced", Font.PLAIN, 1)))
                .createTerminal();

        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);

        this.tg = screen.newTextGraphics();
        screen.startScreen();


        /*this.kid = new Kid(400, 400);
        KidView kidView = new KidView(tg, kid);
        this.kidController = new kidController(kid);
        
        this.car = new Car(400, 0);
        CarView carView = new CarView(tg, car);
        this.carController = new CarController(car);


        tg.setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        tg.fill(' ');


        screen.refresh();

        while (true) {
            KeyStroke keyStroke = screen.pollInput();

            if (keyStroke != null) {
                if (keyStroke.getKeyType() == KeyType.Escape) {
                    break; // Exit the game loop on Escape key
                }

                if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
                    //kidController.move();

                    ClearScreen();
                    //kidView.draw();

                }
                screen.refresh();
            }
        }

        screen.close();
    }

    public void ClearScreen() {
        tg.setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        tg.fillRectangle(new TerminalPosition(0,0), getTerminalSize(), ' ');
    }*/


    @Override
    public void clearScreen() {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        this.graphics.fillRectangle(new TerminalPosition(0,0), getTerminalSize(), ' ');
    }

    @Override
    public void refreshScreen() throws IOException {
        this.screen.refresh();
    }
}
