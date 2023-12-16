package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class GameOverViewerTest {

    GameOverViewer gameOverViewer;
    GUI guiMock;
    GameOverMenu gameOverMenuMock;
    Road roadMock;

    String[] ARROW_RIGHT = {
            "$$",
            "$$$$",
            "$GG$$",
            "$GGG$$$",
            "$GGGGG$$$",
            "$GGGGGGG$$$",
            "$GGGGGGGGG$$$",
            "$GGGGGGGGGGG$$$",
            "$GGGGGGGGGGG$$$",
            "$GGGGGGGGG$$$",
            "$GGGGGGG$$$",
            "$GGGGG$$$",
            "$GGG$$$",
            "$GG$$",
            "$$$$",
            "$$",

    };

    @BeforeEach
    void init() {
        guiMock = Mockito.mock(GUI.class);
        gameOverMenuMock = Mockito.mock(GameOverMenu.class);
        roadMock = Mockito.mock(Road.class);

        Joe joeMock = Mockito.mock(Joe.class);
        when(roadMock.getJoe()).thenReturn(joeMock);
        when(gameOverMenuMock.getCurrentGame()).thenReturn(roadMock);
    }

    @Test
    void drawElements() {
        gameOverViewer = new GameOverViewer(gameOverMenuMock);

        Option option1 = new Option("Option 1", new Position(100, 200), null);
        Option option2 = new Option("Option 2", new Position(150, 250), null);
        when(gameOverMenuMock.getNumberOptions()).thenReturn(2);
        when(gameOverMenuMock.getOption(0)).thenReturn(option1);
        when(gameOverMenuMock.getOption(1)).thenReturn(option2);
        when(gameOverMenuMock.isSelectedOption(0)).thenReturn(true);
        when(gameOverMenuMock.isSelectedOption(1)).thenReturn(false);

        Position expectedPosition1 = option1.position();
        Position expectedPosition2 = option2.position();

        gameOverViewer.drawElements(guiMock);

        verify(guiMock).drawText(expectedPosition1, "Option 1", "#FFFFFF");
        verify(guiMock).drawText(expectedPosition2, "Option 2", "#FFFFFF");
        verify(guiMock).drawImage(new Position(expectedPosition1.getX() - 15, expectedPosition1.getY()), ARROW_RIGHT);
    }

    @Test
    void win() {
        when(gameOverMenuMock.isWin()).thenReturn(true);

        gameOverViewer = new GameOverViewer(gameOverMenuMock);
        gameOverViewer.drawTitle(guiMock);

        verify(guiMock).drawText(any(), eq("Congratulations"), eq("#FFFFFF"));
    }

    @Test
    void lose() {
        when(gameOverMenuMock.isWin()).thenReturn(false);

        gameOverViewer = new GameOverViewer(gameOverMenuMock);
        gameOverViewer.drawTitle(guiMock);

        verify(guiMock).drawText(any(), eq("game over"), eq("#FFFFFF"));
    }

    @Test
    void informationWinDraw() {
        when(gameOverMenuMock.getCurrentGame().getJoe().getScore()).thenReturn(1234);
        when(gameOverMenuMock.getCurrentGame().getCurrentLevel()).thenReturn(10);

        gameOverViewer = new GameOverViewer(gameOverMenuMock);
        gameOverViewer.drawInformation(guiMock);

        verify(guiMock).drawImage(any(), any());

        verify(guiMock).drawText(any(), eq("score"), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq("level"), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq(1234), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq(9), eq("#D30000"));
    }

    @Test
    void informationLoseDraw() {
        when(gameOverMenuMock.getCurrentGame().getJoe().getScore()).thenReturn(1234);
        when(gameOverMenuMock.getCurrentGame().getCurrentLevel()).thenReturn(3);

        gameOverViewer = new GameOverViewer(gameOverMenuMock);
        gameOverViewer.drawInformation(guiMock);

        verify(guiMock).drawImage(any(), any());

        verify(guiMock).drawText(any(), eq("score"), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq("level"), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq(1234), eq("#FFFFFF"));
        verify(guiMock).drawText(any(), eq(3), eq("#FFFFFF"));
    }

}