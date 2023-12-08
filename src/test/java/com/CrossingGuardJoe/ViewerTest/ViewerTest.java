package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.viewer.Viewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewerTest {

    @Test
    public void testViewerDraw() throws IOException {
        GUI guiMock = mock(GUI.class);
        Viewer<String> viewer = new Viewer<String>("Test Model") {
            @Override
            public void drawElements(GUI gui) {}
        };

        viewer.draw(guiMock);

        verify(guiMock, times(1)).clearScreen();
        verify(guiMock, times(1)).refreshScreen();
    }

}
