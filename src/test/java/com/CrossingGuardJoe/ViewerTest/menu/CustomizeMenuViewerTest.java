package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.ColorPaletteMenu;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Color;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.menu.CustomizeMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void drawElements() {
        Option optionMock = mock(Option.class);

        List<List<Option>> menuLevels = Arrays.asList(Arrays.asList(optionMock));
        when(customizeMenuMock.getMenuLevels()).thenReturn(menuLevels);
        when(customizeMenuMock.isSelectedElement(anyInt())).thenReturn(true);
        when(customizeMenuMock.isSelectedOption(anyInt(), anyInt())).thenReturn(true);
        when(optionMock.position()).thenReturn(new Position(100, 100));
        when(optionMock.image()).thenReturn(null);
        when(optionMock.name()).thenReturn("Option Name");

        CustomizeMenuViewer customizeMenuViewer = new CustomizeMenuViewer(customizeMenuMock);

        customizeMenuViewer.drawElements(guiMock);

        verify(guiMock).drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(235, 300, ' ', 2, 'G'));
        verify(guiMock).drawImage(new Position(100, 100), null);
        verify(guiMock).drawText(new Position(99, 99), "Option Name", "#FFFFFF");
        verify(guiMock).drawImage(new Position(70, 100), ARROW_RIGHT);

        verify(customizeMenuMock, times(1)).isSelectedElement(anyInt());
        verify(optionMock, times(1)).position();
        verify(optionMock, times(1)).image();
        verify(optionMock, times(1)).name();
    }

}
