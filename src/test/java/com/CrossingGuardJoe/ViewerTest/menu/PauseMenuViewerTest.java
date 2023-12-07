package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.viewer.menu.MenuViewer;
import com.CrossingGuardJoe.viewer.menu.PauseMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PauseMenuViewerTest {
    PauseMenu pauseMenuMock;
    GUI guiMock;
    Position positionMock;
    PauseMenuViewer pauseMenuViewer;

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
        pauseMenuMock = mock(PauseMenu.class);
        guiMock = mock(GUI.class);
        positionMock = mock(Position.class);
        pauseMenuViewer = new PauseMenuViewer(pauseMenuMock);
    }

    @Test
    void drawTitle() {
        pauseMenuViewer.drawTitle(guiMock);

        verify(guiMock).drawText(new Position(207, 100), "Game paused", "#FFFFFF");
    }

    @Test
    void drawElements() {
        Option option1 = new Option("Option 1", new Position(100, 200), null);
        Option option2 = new Option("Option 2", new Position(150, 250), null);
        when(pauseMenuMock.getNumberOptions()).thenReturn(2);
        when(pauseMenuMock.getOption(0)).thenReturn(option1);
        when(pauseMenuMock.getOption(1)).thenReturn(option2);
        when(pauseMenuMock.isSelectedOption(0)).thenReturn(true);
        when(pauseMenuMock.isSelectedOption(1)).thenReturn(false);

        Position expectedPosition1 = option1.position();
        Position expectedPosition2 = option2.position();

        pauseMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(expectedPosition1, "Option 1", "#FFFFFF");
        verify(guiMock).drawText(expectedPosition2, "Option 2", "#FFFFFF");
        verify(guiMock).drawImage(new Position(expectedPosition1.getX() - 15, expectedPosition1.getY()), ARROW_RIGHT);
    }

    @Test
    void drawInformation() {
        pauseMenuViewer.drawInformation(guiMock);

        verifyNoInteractions(guiMock);
    }
}
