package com.aor.CrossingGuardJoe.GUITest;

import com.aor.CrossingGuardJoe.gui.LanternaGUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LanternaGUITest {

    private LanternaGUI lanternaGUI;
    private TextGraphics textGraphicsMock;
    private Screen screenMock;

    @BeforeEach
    public void setUp() throws IOException {
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
        LanternaGUI gui = mock(LanternaGUI.class);

        Position position = new Position(5, 5);
        String[] image = {
                "###",
                "###",
                "###"
        };

        gui.drawImage(position, image);

        verify(gui, times(1)).drawLine(5, 5, "###");
        verify(gui, times(1)).drawLine(5, 6, "###");
        verify(gui, times(1)).drawLine(5, 7, "###");
    }

    @Test
    public void testDrawLine() {
        LanternaGUI gui = mock(LanternaGUI.class);

        int x = 3;
        int y = 3;
        String imageLine = "###";

        gui.drawLine(x, y, imageLine);

        verify(gui, times(1)).setColor('#');
        verify(gui.getGraphics(), times(3)).fillRectangle(any(), any(), eq(' '));
    }

    @Test
    public void testSetColor() {
        LanternaGUI gui = mock(LanternaGUI.class);

        char character = '#';
        gui.setColor(character);

        verify(gui, times(1)).setBackgroundColor("#FFFFFF"); // Assuming #FFFFFF for '#' color
    }

}
