package com.aor.CrossingGuardJoe.gui;


import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.viewer.Color;
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

public class LanternaGUI implements GUI {
    private TextGraphics graphics;
    private Screen screen;
    private Terminal terminal;
    private int width;
    private int height;
    private Color color;

    public LanternaGUI(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        createTerminal();
    }

    public TextGraphics getGraphics() {
        return this.graphics;
    }

    public Screen getScreen() { return this.screen; }

    public Terminal getTerminal() { return this.terminal; }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    private void createTerminal() throws IOException {
        TerminalSize terminalSize = new TerminalSize(getWidth(), getHeight());
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

    @Override
    public void clearScreen() {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#7F7976"));
        fillRectangle(new Position(0,0), getWidth(), getHeight());
    }

    @Override
    public void refreshScreen() throws IOException {
        this.screen.refresh();
    }

    @Override
    public void setBackgroundColor(String colorHexCode) {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString(colorHexCode));
        fillRectangle(new Position(0,0), getWidth(), getHeight());
    }

    @Override
    public void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight) {
        this.graphics.fillRectangle(new TerminalPosition(initialPosition.getX(), initialPosition.getY()),
                new TerminalSize(rectangleWidth, rectangleHeight),
                ' ');
    }

    @Override
    public void drawImage(Position position, String[] image) {
        int yPos = position.getY();
        for (String imageLine : image) {
            drawLine(position.getX(), yPos, imageLine);
            yPos++;
        }
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawRoadLines() {
        setColor('«');
        fillRectangle(new Position(0, 0),150, 500);
        fillRectangle(new Position(850, 0), 150, 500);

        int iniX = 167;
        for (int i = 0; i < 834 - iniX - 15; i += 24) {
            fillRectangle(new Position(iniX + i, 368), 16, 50);
        }

        fillRectangle(new Position(326, 0), 4, 340);
        fillRectangle(new Position(500, 0), 4, 340);
        fillRectangle(new Position(674, 0), 4, 340);


        setColor('»');
        fillRectangle(new Position(150, 0), 2, 500);
        fillRectangle(new Position(154, 0), 2, 500);
        fillRectangle(new Position(848, 0), 2, 500);
        fillRectangle(new Position(844, 0), 2, 500);
    }

    public void setColor(char character) {
        this.color = Color.getColor(character);
        if (color != null) {
            graphics.setBackgroundColor(TextColor.Factory.fromString(color.getColorHexCode()));
        }
    }

    public void drawLine(int x, int y, String imageLine) {
        int xPos = x;
        for (char character : imageLine.toCharArray()) {
            if (character != ' ') {
                setColor(character);
                fillRectangle(new Position(x + xPos, y), 1, 1);
            }
            xPos++;
        }
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();

        if (keyStroke != null) {
            KeyType keyType = keyStroke.getKeyType();
            switch (keyType) {
                case ArrowLeft:
                    return ACTION.LEFT;
                case ArrowRight:
                    return ACTION.RIGHT;
                case ArrowUp:
                    return ACTION.UP;
                case ArrowDown:
                    return ACTION.DOWN;
                case Enter:
                    return ACTION.SELECT;
                case EOF:
                    return ACTION.QUIT;
                default:
                    break;
            }
        }

        return ACTION.NONE;
    }


}
