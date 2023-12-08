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

    @Test
    public void testDrawText() {
        TextGraphics textGraphicsMock = mock(TextGraphics.class);

        lanternaGUI.setGraphics(textGraphicsMock);

        Position position = new Position(5, 5);
        String[] testImage = {
                "#####",
                "#####",
                "#####"
        };
        Object text = "hello";

        FontImageFactory fontImageFactoryMock = mock(FontImageFactory.class);
        when(fontImageFactoryMock.getImageRepresentation(text)).thenReturn(testImage);

        lanternaGUI.drawText(position, text, "#FFFFFF");

        verify(textGraphicsMock, atLeastOnce())
                .setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));

        verify(textGraphicsMock, atLeastOnce())
                .fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void testSetColor() {
        char character = 'R';

        lanternaGUI.setColor(character);

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#FF0000")); // Assuming 'R' corresponds to red color
    }

    @Test
    public void testGetNextAction() throws IOException {
        Screen screenMock = mock(Screen.class);
        lanternaGUI.setScreen(screenMock);

        KeyStroke arrowLeft = mock(KeyStroke.class);
        when(arrowLeft.getKeyType()).thenReturn(KeyType.ArrowLeft);

        KeyStroke arrowRight = mock(KeyStroke.class);
        when(arrowRight.getKeyType()).thenReturn(KeyType.ArrowRight);

        KeyStroke arrowUp = mock(KeyStroke.class);
        when(arrowUp.getKeyType()).thenReturn(KeyType.ArrowUp);

        KeyStroke arrowDown = mock(KeyStroke.class);
        when(arrowDown.getKeyType()).thenReturn(KeyType.ArrowDown);

        KeyStroke enter = mock(KeyStroke.class);
        when(enter.getKeyType()).thenReturn(KeyType.Enter);

        KeyStroke escape = mock(KeyStroke.class);
        when(escape.getKeyType()).thenReturn(KeyType.Escape);

        KeyStroke eof = mock(KeyStroke.class);
        when(eof.getKeyType()).thenReturn(KeyType.EOF);

        when(screenMock.pollInput())
                .thenReturn(arrowLeft)
                .thenReturn(arrowRight)
                .thenReturn(arrowUp)
                .thenReturn(arrowDown)
                .thenReturn(enter)
                .thenReturn(escape)
                .thenReturn(eof)
                .thenReturn(null);

        assertEquals(GUI.ACTION.LEFT, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.RIGHT, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.UP, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.DOWN, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.SELECT, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.ESC, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.QUIT, lanternaGUI.getNextAction());
        assertEquals(GUI.ACTION.NONE, lanternaGUI.getNextAction());

        verify(screenMock, times(8)).pollInput();
    }

}
