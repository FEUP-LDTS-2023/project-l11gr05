package com.CrossingGuardJoe.GUITest;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.gui.LanternaGUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        lanternaGUI.fillRectangle(initialPosition, rectangleWidth, rectangleHeight);

        verify(textGraphicsMock).fillRectangle(
                eq(new TerminalPosition(initialPosition.getX(), initialPosition.getY())),
                eq(new TerminalSize(rectangleWidth, rectangleHeight)),
                eq(' ')
        );
    }

    @Test
    public void testDrawImage() {
        Position position = new Position(5, 5);
        String[] testImage = {
                "#####",
                "#####",
                "#####"
        };

        lanternaGUI.drawImage(position, testImage);

        verify(textGraphicsMock, times(testImage[0].length() * testImage.length)).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void testCloseScreen() throws IOException {
        lanternaGUI.closeScreen();

        verify(screenMock).close();
    }

    @Test
    public void testSetColorHexaCode() {
        lanternaGUI.setColorHexaCode("#FF0000");

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
    }

    @Test
    public void testAddAndGetColorMapping() {
        lanternaGUI.addColorMapping('a', 'b');
        assertEquals('b', lanternaGUI.getMappedCharacter('a'));
    }

    @Test
    public void testDrawImageCustomColor() {
        Position position = new Position(5, 5);
        String[] testImage = {
                "#####",
                "#####",
                "#####"
        };
        String colorHexCode = "#FFFF00";

        lanternaGUI.drawImageCustomColor(position, testImage, colorHexCode);

        verify(textGraphicsMock, times(testImage[0].length() * testImage.length))
                .setBackgroundColor(TextColor.Factory.fromString(colorHexCode));
        verify(textGraphicsMock, times(testImage[0].length() * testImage.length)).fillRectangle(any(), any(), anyChar());
    }


}
