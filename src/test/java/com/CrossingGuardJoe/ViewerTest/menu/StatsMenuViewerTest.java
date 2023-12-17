package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import com.CrossingGuardJoe.viewer.menu.StatsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StatsMenuViewerTest {
    StatsMenu statsMenuMock;
    GUI guiMock;
    StatsMenuViewer statsMenuViewer;

    String[] KEY_ESC = {
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$KKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$$$$$$KKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$KK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
    };

    @BeforeEach
    void init() {
        statsMenuMock = mock(StatsMenu.class);
        guiMock = mock(GUI.class);
        statsMenuViewer = new StatsMenuViewer(statsMenuMock);
    }

    @Test
    void drawTitle() {
        statsMenuViewer.drawTitle(guiMock);

        verify(guiMock).drawText(new Position(207, 100), "Game stats", "#FFFFFF");
    }

    @Test
    void drawInformation() {
        when(statsMenuMock.getCurrentScore()).thenReturn(500);
        when(statsMenuMock.getCurrentLevel()).thenReturn(3);
        when(statsMenuMock.getHighestScore()).thenReturn(1000);
        when(statsMenuMock.getHighestLevel()).thenReturn(5);

        statsMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawText(new Position(210, 210), "score", "#FFFFFF");
        verify(guiMock).drawText(new Position(210, 250), "level", "#FFFFFF");
        verify(guiMock).drawText(new Position(150, 300), "highest score", "#FFFFFF");
        verify(guiMock).drawText(new Position(150, 340), "highest level", "#FFFFFF");

        verify(guiMock).drawText(new Position(275, 210), 500, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 250), 3, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 300), 1000, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 340), 5, "#FFFFFF");

        verify(guiMock).drawImage(new Position(4, 4), KEY_ESC);
    }

    @Test
    void drawElements() {
        when(statsMenuMock.getCurrentScore()).thenReturn(500);
        when(statsMenuMock.getCurrentLevel()).thenReturn(3);
        when(statsMenuMock.getHighestScore()).thenReturn(1000);
        when(statsMenuMock.getHighestLevel()).thenReturn(5);

        statsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(207, 100), "Game stats", "#FFFFFF");
        verify(guiMock).drawText(new Position(210, 210), "score", "#FFFFFF");
        verify(guiMock).drawText(new Position(210, 250), "level", "#FFFFFF");
        verify(guiMock).drawText(new Position(150, 300), "highest score", "#FFFFFF");
        verify(guiMock).drawText(new Position(150, 340), "highest level", "#FFFFFF");

        verify(guiMock).drawText(new Position(275, 210), 500, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 250), 3, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 300), 1000, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 340), 5, "#FFFFFF");

        verify(guiMock).drawImage(new Position(4, 4), KEY_ESC);

        when(statsMenuMock.getCurrentLevel()).thenReturn(10);
        when(statsMenuMock.getHighestLevel()).thenReturn(10);
        statsMenuViewer.drawElements(guiMock);
        verify(guiMock).drawText(new Position(275, 250), 9, "#FFFFFF");
        verify(guiMock).drawText(new Position(275, 340), 9, "#FFFFFF");
    }
}
