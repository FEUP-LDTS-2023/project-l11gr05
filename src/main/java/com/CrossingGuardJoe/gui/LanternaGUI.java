package com.CrossingGuardJoe.gui;


import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.Color;
import com.CrossingGuardJoe.viewer.ColorCustomize;
import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
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
import com.groupcdg.pitest.annotations.DoNotMutate;

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
    private final ColorCustomize colorCustomize = ColorCustomize.getInstance();

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        this.width = width;
        this.height = height;
    }

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @DoNotMutate
    public void createTerminal() throws IOException, URISyntaxException, FontFormatException {
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

    @DoNotMutate
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/VCR_OSD_MONO_1.001.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
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
    public void drawText(Position position, Object text, String colorHexCode) {
        String[] textImage = new FontImageFactory().getImageRepresentation(text);
        drawImageCustomColor(new Position(position.getX() + 1, position.getY() + 1),
                            textImage, "#000000");
        drawImageCustomColor(position, textImage, colorHexCode);
    }

    @Override
    public void setColorHexaCode(String hexCode) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(hexCode));
    }

    @Override
    public void addColorMapping(char oldCharacter, char newCharacter) {
        colorCustomize.addMapping(oldCharacter, newCharacter);
    }

    public void drawImageCustomColor(Position position, String[] image, String colorHexCode) {
        int yPos = position.getY();
        for (String imageLine : image) {
            drawLineCustomColor(position.getX(), yPos, imageLine, colorHexCode);
            yPos++;
        }
    }

    public void setColor(char character) {
        Color color = Color.getColor(character);
        if (color != null) {
            graphics.setBackgroundColor(TextColor.Factory.fromString(color.getColorHexCode()));
        }
    }

    public void drawLine(int x, int y, String imageLine) {
        int xPos = x;
        for (char character : imageLine.toCharArray()) {
            if (character != ' ') {
                char colorCharacter = getMappedCharacter(character);
                setColor(colorCharacter);
                fillRectangle(new Position(x + xPos, y), 1, 1);
            }
            xPos++;
        }
    }

    public void drawLineCustomColor(int x, int y, String imageLine, String colorHexCode) {
        int xPos = x;
        for (char character : imageLine.toCharArray()) {
            if (character != ' ') {
                setColorHexaCode(colorHexCode);
                fillRectangle(new Position(x + xPos, y), 1, 1);
            }
            xPos++;
        }
    }

    public char getMappedCharacter(char character) {
        return colorCustomize.getMappedCharacter(character);
    }

    @Override
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
                case Escape:
                    return ACTION.ESC;
                case EOF:
                    return ACTION.QUIT;
                default:
                    break;
            }
        }

        return ACTION.NONE;
    }

}
