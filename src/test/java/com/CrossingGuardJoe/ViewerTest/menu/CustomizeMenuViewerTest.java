package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.ColorPaletteMenu;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import com.CrossingGuardJoe.viewer.images.defined.*;
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
    ColorPaletteMenu colorPaletteMenuMock;

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
        colorPaletteMenuMock = mock(ColorPaletteMenu.class);
        when(customizeMenuMock.getColorPaletteMenu()).thenReturn(colorPaletteMenuMock);

        int JOE_X = 80;
        int OPTIONS_Y = 230;
        List<Option> Joe = Arrays.asList(
                new Option("", new Position(JOE_X - 2, 95), JoeImages.getJoeStandImage()),
                new Option("Cap", new Position(JOE_X, OPTIONS_Y), new FontImageFactory().getImageRepresentation("Cap")),
                new Option("Clothes", new Position(JOE_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("Clothes")),
                new Option("Vest", new Position(JOE_X, OPTIONS_Y + 60), new FontImageFactory().getImageRepresentation("Vest")),
                new Option("Shoes", new Position(JOE_X, OPTIONS_Y + 90), new FontImageFactory().getImageRepresentation("Shoes"))
        );

        int KIDS_X = 235;
        List<Option> Kids = Arrays.asList(
                new Option("", new Position(KIDS_X + 5, 115), KidImages.getKidStandImage()),
                new Option("Shirt", new Position(KIDS_X, OPTIONS_Y), new FontImageFactory().getImageRepresentation("Shirt")),
                new Option("Pants", new Position(KIDS_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("Pants")),
                new Option("BackPack", new Position(KIDS_X, OPTIONS_Y + 60), new FontImageFactory().getImageRepresentation("Backpack")),
                new Option("Shoes", new Position(KIDS_X, OPTIONS_Y + 90), new FontImageFactory().getImageRepresentation("Shoes"))
        );

        int CARS_X = 403;
        List<Option> Cars = Arrays.asList(
                new Option("", new Position(CARS_X - 27, 100), CarImage.getCarImage()),
                new Option("Car", new Position(CARS_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("CAR"))
        );

        when(customizeMenuMock.getMenuLevels()).thenReturn(Arrays.asList(Joe, Kids, Cars));



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
    public void testDrawElementsJoe() {
        when(customizeMenuMock.isSelectedJoeCustomize()).thenReturn(true);
        customizeMenuViewer.drawElements(guiMock);

        verify(guiMock, times(28)).drawImage(any(Position.class), any(String[].class));
    }

    @Test
    public void testDrawElementsKids() {
        when(customizeMenuMock.isSelectedKidsCustomize()).thenReturn(true);
        customizeMenuViewer.drawElements(guiMock);

        verify(guiMock, times(28)).drawImage(any(Position.class), any(String[].class));
    }

    @Test
    public void testDrawElementsCars() {
        when(customizeMenuMock.isSelectedCarsCustomize()).thenReturn(true);
        customizeMenuViewer.drawElements(guiMock);

        verify(guiMock, times(28)).drawImage(any(Position.class), any(String[].class));
    }

}
