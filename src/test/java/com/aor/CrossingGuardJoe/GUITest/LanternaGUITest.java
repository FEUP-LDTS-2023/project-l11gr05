package com.aor.CrossingGuardJoe.GUITest;

import com.aor.CrossingGuardJoe.Model.Position;
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
        lanternaGUI = new LanternaGUI(80, 24); // Considerando um tamanho padrão de 80x24 para os testes

        // Mocks necessários para os testes
        textGraphicsMock = Mockito.mock(TextGraphics.class);
        screenMock = Mockito.mock(Screen.class);

        lanternaGUI.setGraphics(textGraphicsMock);
        lanternaGUI.setScreen(screenMock);
    }

    @Test
    public void testClearScreen() {
        lanternaGUI.clearScreen();

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#7f7976"));
        verify(textGraphicsMock).fillRectangle(any(), any(), anyChar()); // Use TextCharacter em vez de char
    }

    @Test
    public void testRefreshScreen() throws IOException {
        lanternaGUI.refreshScreen();

        verify(screenMock).refresh();
    }

    @Test
    public void testSetBackgroundColor() {
        lanternaGUI.setBackgrounColor("#FFFFFF");

        verify(textGraphicsMock).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(textGraphicsMock).fillRectangle(any(), any(), anyChar()); // Use TextCharacter em vez de char
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

}
