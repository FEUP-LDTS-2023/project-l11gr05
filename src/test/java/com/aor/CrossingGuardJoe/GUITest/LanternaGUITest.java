package com.aor.CrossingGuardJoe.GUITest;

import com.aor.CrossingGuardJoe.gui.LanternaGUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.viewer.Color;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class LanternaGUITest {

    private LanternaGUI lanternaGUI;
    private TextGraphics textGraphicsMock;
    private Screen screenMock;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        lanternaGUI = new LanternaGUI(80, 24);

        textGraphicsMock = Mockito.mock(TextGraphics.class);
        screenMock = Mockito.mock(Screen.class);

        lanternaGUI.setGraphics(textGraphicsMock);
        lanternaGUI.setScreen(screenMock);
    }

    @Test
    public void testClearScreen() {
        lanternaGUI.clearScreen();

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        verify(textGraphicsMock).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void testRefreshScreen() throws IOException {
        lanternaGUI.refreshScreen();

        verify(screenMock).refresh();
    }

    @Test
    public void testSetBackgroundColor() {
        lanternaGUI.setBackgroundColor("#FFFFFF");

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(textGraphicsMock).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void testFillRectangle() {
        Position initialPosition = new Position(5, 5);
        int rectangleWidth = 10;
        int rectangleHeight = 8;
        Character character = '*';

        lanternaGUI.fillRectangle(initialPosition, rectangleWidth, rectangleHeight, character);

        verify(textGraphicsMock).fillRectangle(
                eq(new TerminalPosition(initialPosition.getX(), initialPosition.getY())),
                eq(new TerminalSize(rectangleWidth, rectangleHeight)),
                eq(character)
        );
    }

    @Test
    public void testDrawImage() {
        Position position = new Position(5, 5);
        String[] testImage = {  "#####",
                                "#####",
                                "#####"  };

        lanternaGUI.drawImage(position, testImage);

        // Verify if drawLine was called for each line in the image
        verify(lanternaGUI, times(testImage.length)).drawLine(eq(position.getX()), anyInt(), anyString());
    }

    @Test
    public void testDrawLine() {
        int x = 2;
        int y = 3;
        String testLine = "####";

        lanternaGUI.drawLine(x, y, testLine);

        // Verify if fillRectangle was called for each character in the line
        verify(lanternaGUI, times(testLine.length())).fillRectangle(any(), anyInt(), anyInt(), anyChar());
    }

    @Test
    public void testSetColor() {
        char testCharacter = 'W';
        Color mockedColor = mock(Color.class);
        when(Color.getColor(testCharacter)).thenReturn(mockedColor);
        when(mockedColor.getColorHexCode()).thenReturn("#FFFFFF");

        lanternaGUI.setColor(testCharacter);

        // Verify if setBackgroundColor was called with the color's hex code
        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }

}
