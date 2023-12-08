package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.ColorPaletteMenu;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Color;
import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import com.CrossingGuardJoe.viewer.images.defined.CarImage;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;
import com.CrossingGuardJoe.viewer.images.defined.KidImages;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.menu.CustomizeMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CustomizeMenuViewerTest {

    GUI guiMock;
    CustomizeMenuViewer customizeMenuViewer;
    CustomizeMenu customizeMenuMock;


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
        guiMock = mock(GUI.class);
        customizeMenuMock = mock(CustomizeMenu.class);
        customizeMenuViewer = new CustomizeMenuViewer(customizeMenuMock);

    }

    @Test
    public void testDrawTitle() {
        customizeMenuViewer.drawTitle(guiMock);

        verify(guiMock, times(1)).drawText(any(), anyString(), anyString());
    }

    @Test
    public void testDrawInformation() {
        customizeMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawImage(new Position(4, 4), KEY_ESC);
    }

}
