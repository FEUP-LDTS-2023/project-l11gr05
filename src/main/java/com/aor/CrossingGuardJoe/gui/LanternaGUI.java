package com.aor.CrossingGuardJoe.gui;


import com.aor.CrossingGuardJoe.controller.game.CarController;
import com.aor.CrossingGuardJoe.controller.game.KidController;
import com.aor.CrossingGuardJoe.model.game.Car;
import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.game.CarView;
import com.aor.CrossingGuardJoe.view.game.JoeView;
import com.aor.CrossingGuardJoe.view.game.KidView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class LanternaGUI {/*
    public TextGraphics tg;
    private Kid kid;
    private Car car;

    private KidController kidController;
    private CarController carController;
    private TerminalSize terminalSize;

    public TerminalSize getTerminalSize() {
        return this.terminalSize;
    }
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
        this.kidController = new kidController(kid);*/

       // this.car = new Car(400, 0);
        //CarView carView = new CarView(tg, car);
      //  this.carController = new CarController(car);


       // tg.setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
       // tg.fill(' ');

        //test to print on terminal
      //  JoeView b = new JoeView(tg);
      //  CarView c = new CarView(tg);

      /*  screen.refresh();

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
    }
*/

}
