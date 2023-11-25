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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private TextGraphics graphics;
    private Screen screen;
    private final int width;
    private final int height;

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        this.width = width;
        this.height = height;
        createTerminal();
    }

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private void createTerminal() throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();

        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorTitle("Crossing Guard Joe");
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        this.screen.startScreen();
        this.graphics = screen.newTextGraphics();
        setBackgroundColor("#7F7976");
        refreshScreen();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/VCR_OSD_MONO_1.001.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void clearScreen() {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#7F7976"));
        fillRectangle(new Position(0,0), width, height);
    }

    @Override
    public void refreshScreen() throws IOException {
        this.screen.refresh();
    }

    @Override
    public void closeScreen() throws IOException {
        this.screen.close();
    }

    @Override
    public void setBackgroundColor(String colorHexCode) {
        this.graphics.setBackgroundColor(TextColor.Factory.fromString(colorHexCode));
        fillRectangle(new Position(0,0), width, height);
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
    public void setColorHexaCode(String hexaCode) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(hexaCode));
    }

    private void setColor(char character) {
        Color color = Color.getColor(character);
        if (color != null) {
            graphics.setBackgroundColor(TextColor.Factory.fromString(color.getColorHexCode()));
        }
    }

    private void drawLine(int x, int y, String imageLine) {
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
