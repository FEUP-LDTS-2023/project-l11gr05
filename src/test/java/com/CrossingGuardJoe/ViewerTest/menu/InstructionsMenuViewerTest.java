package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.viewer.images.defined.CarImage;
import com.CrossingGuardJoe.viewer.images.defined.HUDImages;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;
import com.CrossingGuardJoe.viewer.images.defined.KidImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.menu.InstructionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class InstructionsMenuViewerTest {
    InstructionsMenu instructionsMenuMock;
    GUI guiMock;
    InstructionsMenuViewer instructionsMenuViewer;

    String[] KEY_UP = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$KKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_DOWN = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$KKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_RIGHT = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$KKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$KKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$KKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$KKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$KKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$KKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$KKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$KKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_LEFT = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKK$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKK$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKK$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKK$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKK$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKK$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKK$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKK$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKK$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKK$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    @BeforeEach
    void init() {
        instructionsMenuMock = mock(InstructionsMenu.class);
        guiMock = mock(GUI.class);
        instructionsMenuViewer = new InstructionsMenuViewer(instructionsMenuMock);
        Mockito.when(instructionsMenuMock.getTotalPages()).thenReturn(5);
    }

    @Test
    void titleDraw() {
        instructionsMenuViewer.drawTitle(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Instructions"), Mockito.eq("#FFFFFF"));
    }

    @Test
    void informationDraw() {
        Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(3);

        instructionsMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Page"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq("of"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(3), Mockito.eq("#FFFFFF"));
    }

    @Test
    void informationLastPageDraw() {
        Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(5);

        instructionsMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Page"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq("of"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#D30000"));
    }

    @Test
    void testDrawPageOne() {
        when(instructionsMenuMock.getCurrentPage()).thenReturn(1);

        instructionsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(50, 100), "you are Joe", "#FFFFFF");
        verify(guiMock).drawText(new Position(70, 120), "a crossing guard", "#FFFFFF");
        verify(guiMock).drawText(new Position(50, 400), "click once to move", "#FFFFFF");

        verify(guiMock).drawImage(new Position(150, 190), JoeImages.getJoeStandImage());
        verify(guiMock).drawImage(new Position(230, 190), JoeImages.getJoeWalkleftImage());
        verify(guiMock).drawImage(new Position(310, 190), JoeImages.getJoeWalkrightImage());

        verify(guiMock).drawImage(new Position(235, 310), KEY_LEFT);
        verify(guiMock).drawImage(new Position(315, 310), KEY_RIGHT);
    }

    @Test
    void testDrawPageTwo() {
        when(instructionsMenuMock.getCurrentPage()).thenReturn(2);

        instructionsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(50, 100), "you will help", "#FFFFFF");
        verify(guiMock).drawText(new Position(70, 120), "the kids to cross the road", "#FFFFFF");
        verify(guiMock).drawText(new Position(50, 400), "click once to order", "#FFFFFF");

        verify(guiMock).drawImage(new Position(170, 180), JoeImages.getJoeStopImage());
        verify(guiMock).drawImage(new Position(290, 180), JoeImages.getJoePassImage());

        verify(guiMock).drawImage(new Position(200, 220), KidImages.getKidStandImage());
        verify(guiMock).drawImage(new Position(280, 220), KidImages.getKidWalkImage());

        verify(guiMock).drawImage(new Position(180, 310), KEY_UP);
        verify(guiMock).drawImage(new Position(295, 310), KEY_DOWN);
    }

    @Test
    void testDrawPageThree() {
        when(instructionsMenuMock.getCurrentPage()).thenReturn(3);

        instructionsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(50, 100), "be careful", "#FFFFFF");
        verify(guiMock).drawText(new Position(70, 120), "with rude drivers", "#FFFFFF");

        verify(guiMock).drawImage(new Position(150, 195), CarImage.getCarImage());
        verify(guiMock).drawImage(new Position(280, 195), CarImage.getCarImage());

        verify(guiMock).drawImage(new Position(190, 245), KidImages.getKidHitImage());
        verify(guiMock).drawImage(new Position(320, 215), JoeImages.getJoeHitrightImage());
    }

    @Test
    void testDrawPageFour() {
        when(instructionsMenuMock.getCurrentPage()).thenReturn(4);

        instructionsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(50, 100), "if you lose a kid", "#FFFFFF");
        verify(guiMock).drawText(new Position(70, 120), "you lose hp", "#FFFFFF");

        verify(guiMock).drawImage(new Position(199, 229), Shape.RectangleFilledGenerator(202, 39, ' ', 2, '$'));
        verify(guiMock).drawImage(new Position(200, 230), HUDImages.getHpBarSliceImage());

        int expectedX = 208;
        for (int i = 0; i < 3; i++) {
            verify(guiMock).drawImage(new Position(expectedX, 234), HUDImages.getHPImage());
            expectedX += 25;
        }
    }

    @Test
    void testDrawPageFive() {
        when(instructionsMenuMock.getCurrentPage()).thenReturn(5);

        instructionsMenuViewer.drawElements(guiMock);

        verify(guiMock).drawText(new Position(50, 100), "try to get", "#FFFFFF");
        verify(guiMock).drawText(new Position(70, 120), "maximum score", "#FFFFFF");

        int SCORE_BAR_X = 185;
        int SCORE_BAR_Y = 230;

        verify(guiMock).drawImage(new Position(SCORE_BAR_X - 1, SCORE_BAR_Y - 1), Shape.RectangleFilledGenerator(266, 39, ' ', 2, '$'));
        verify(guiMock).drawImage(new Position(SCORE_BAR_X, SCORE_BAR_Y), HUDImages.getScoreBarSliceImage());
        verify(guiMock).drawText(new Position(SCORE_BAR_X + 90, SCORE_BAR_Y + 10), 2590, "#FFFFFF");
    }


}
