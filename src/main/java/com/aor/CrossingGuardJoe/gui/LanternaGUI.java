package com.aor.CrossingGuardJoe.gui;

import com.aor.CrossingGuardJoe.controller.game.KidController;
import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.game.KidView;
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

public class LanternaGUI {
    public TextGraphics tg;
    private Kid kid;
    private KidController kidController;

    public LanternaGUI() throws IOException {
        TerminalSize terminalSize = new TerminalSize(1000, 500);
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.newInstance(new Font("Monospaced", Font.PLAIN, 1)))
                .createTerminal();

        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);

        this.tg = screen.newTextGraphics();
        screen.startScreen();


        this.kid = new Kid(100, 100);
        KidView kidView = new KidView(tg, kid);
        this.kidController = new KidController(kid, kidView);


        /*//test to print the KID on terminal
        KidView a = new KidView(tg);*/

        tg.setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        tg.fill(' ');
        kidView.draw();
        screen.refresh();

        while (true) {
            KeyStroke keyStroke = screen.pollInput();

            if (keyStroke != null) {
                if (keyStroke.getKeyType() == KeyType.Escape) {
                    break; // Exit the game loop on Escape key
                }

                kidController.processKey(keyStroke);
                screen.clear();
                kidView.draw();
                screen.refresh();
            }
        }

        screen.close();
    }


}
