package com.aor.CrossingGuardJoe;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;

import java.awt.*;
import java.io.IOException;

public class Display {
    private TextGraphics graphics;
    private Screen screen;
    private TerminalSize displaySize;
    private Font font;

    public Display(int width, int height) throws IOException {
        this.displaySize = new TerminalSize(width, height);

        createDisplay();
    }

    private void createDisplay() throws IOException {
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(getDisplaySize())
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.newInstance(getFont()))
                .createTerminal();
        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        this.graphics = screen.newTextGraphics();
        screen.startScreen();
    }

    public TerminalSize getDisplaySize() {
        return this.displaySize;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return this.font;
    }

}
