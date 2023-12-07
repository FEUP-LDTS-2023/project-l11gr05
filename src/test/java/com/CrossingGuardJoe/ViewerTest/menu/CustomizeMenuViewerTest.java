package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.menu.CustomizeMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CustomizeMenuViewerTest {

    GUI guiMock;
    CustomizeMenuViewer customizeMenuViewer;
    CustomizeMenu customizeMenu;

    @BeforeEach
    void init() {
        guiMock = mock(GUI.class);
        customizeMenu = mock(CustomizeMenu.class);
        customizeMenuViewer = new CustomizeMenuViewer(customizeMenu);
    }

    @Test
    public void testDrawTitle() {
        customizeMenuViewer.drawTitle(guiMock);

        verify(guiMock, times(1)).drawText(any(), anyString(), anyString());
    }

    @Test
    public void testDrawInformation() {
        customizeMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawImage(new Position(4, 4), ToolImages.KEY_ESC);
    }

    @Test
    public void testDrawSelectionBox() {
        customizeMenuViewer.drawSelectionBox(guiMock);

        verify(guiMock).drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(235, 300, 'K', 2, '$'));
        verify(guiMock).drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(235, 300, 'K', 2, '$'));
        verify(guiMock).drawImage(new Position(350, 70), Shape.RectangleFilledGenerator(235, 300, 'K', 2, '$'));
    }

}
