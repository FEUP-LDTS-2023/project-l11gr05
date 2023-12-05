package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.viewer.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorPaletteMenu implements MenuNavigator{
    private final List<Color> colorPalette;
    private int selectedColorIndex;

    public ColorPaletteMenu() {
        this.colorPalette = new ArrayList<>(Arrays.asList(Color.values()));
        this.selectedColorIndex = 0;
    }

    public List<Color> getColorPalette() {
        return colorPalette;
    }

    @Override
    public void navigateLeft() {
        SoundsController.getInstance().play(Sounds.SFX.SELECT);
        selectedColorIndex = (selectedColorIndex - 1 + colorPalette.size()) % colorPalette.size();
    }

    @Override
    public void navigateRight() {
        SoundsController.getInstance().play(Sounds.SFX.SELECT);
        selectedColorIndex = (selectedColorIndex + 1) % colorPalette.size();
    }

    public Color getSelectedColor() {
        return colorPalette.get(selectedColorIndex);
    }

    public boolean isColorSelected(int index) {
        return this.selectedColorIndex == index;
    }

    public int getSelectedColorIndex() {
        return selectedColorIndex;
    }

    public void resetSelectedColorIndex() {
        this.selectedColorIndex = 0;
    }

    @Override
    public void navigateUp() {}

    @Override
    public void navigateDown() {}
}