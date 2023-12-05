package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import com.CrossingGuardJoe.viewer.images.generator.Shape;
import com.CrossingGuardJoe.viewer.images.defined.CarImage;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;
import com.CrossingGuardJoe.viewer.images.defined.KidImages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomizeMenu implements MenuNavigator{
    private final List<List<Option>> menuLevels;
    private final List<Option> definedColors;
    private final ColorPaletteMenu colorPaletteMenu;
    private int currentLevel;
    private int optionSelected;
    private char selectedColorChar;
    boolean colorPaletteSelected = false;
    private char oldColor;
    private char newColor;


    public CustomizeMenu() {
        this.menuLevels = new ArrayList<>();
        this.colorPaletteMenu = new ColorPaletteMenu();
        this.currentLevel = 0;
        this.optionSelected = 1;

        int JOE_X = 80;
        int OPTIONS_Y = 230;
        List<Option> Joe = Arrays.asList(
                new Option("", new Position(JOE_X - 2, 95), JoeImages.JOE_STAND),
                new Option("Cap", new Position(JOE_X, OPTIONS_Y), new FontImageFactory().getImageRepresentation("Cap")),
                new Option("Clothes", new Position(JOE_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("Clothes")),
                new Option("Vest", new Position(JOE_X, OPTIONS_Y + 60), new FontImageFactory().getImageRepresentation("Vest")),
                new Option("Shoes", new Position(JOE_X, OPTIONS_Y + 90), new FontImageFactory().getImageRepresentation("Shoes"))
        );

        int KIDS_X = 235;
        List<Option> Kids = Arrays.asList(
                new Option("", new Position(KIDS_X + 5, 115), KidImages.KID_STAND),
                new Option("Shirt", new Position(KIDS_X, OPTIONS_Y), new FontImageFactory().getImageRepresentation("Shirt")),
                new Option("Pants", new Position(KIDS_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("Pants")),
                new Option("BackPack", new Position(KIDS_X, OPTIONS_Y + 60), new FontImageFactory().getImageRepresentation("Backpack")),
                new Option("Shoes", new Position(KIDS_X, OPTIONS_Y + 90), new FontImageFactory().getImageRepresentation("Shoes"))
        );

        int CARS_X = 403;
        List<Option> Cars = Arrays.asList(
                new Option("", new Position(CARS_X - 27, 100), CarImage.CAR),
                new Option("Car", new Position(CARS_X, OPTIONS_Y + 30), new FontImageFactory().getImageRepresentation("CAR"))
        );

        menuLevels.add(Joe);
        menuLevels.add(Kids);
        menuLevels.add(Cars);

        this.definedColors = Arrays.asList(
                new Option("", new Position(menuLevels.get(0).get(1).position().getX() - 13, menuLevels.get(0).get(1).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '<', 1, '$')),
                new Option("", new Position(menuLevels.get(0).get(2).position().getX() - 13, menuLevels.get(0).get(2).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '!', 1, '$')),
                new Option("", new Position(menuLevels.get(0).get(3).position().getX() - 13, menuLevels.get(0).get(3).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '+', 1, '$')),
                new Option("", new Position(menuLevels.get(0).get(4).position().getX() - 13, menuLevels.get(0).get(4).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '*', 1, '$')),
                new Option("", new Position(menuLevels.get(1).get(1).position().getX() - 13, menuLevels.get(1).get(1).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '\'', 1, '$')),
                new Option("", new Position(menuLevels.get(1).get(2).position().getX() - 13, menuLevels.get(1).get(2).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '(', 1, '$')),
                new Option("", new Position(menuLevels.get(1).get(3).position().getX() - 13, menuLevels.get(1).get(3).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, ')', 1, '$')),
                new Option("", new Position(menuLevels.get(1).get(4).position().getX() - 13, menuLevels.get(1).get(4).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '&', 1, '$')),
                new Option("", new Position(menuLevels.get(2).get(1).position().getX() - 13, menuLevels.get(2).get(1).position().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '@', 1, '$'))
        );
    }

    public List<List<Option>> getMenuLevels() {
        return this.menuLevels;
    }

    @Override
    public void navigateLeft() {
        currentLevel = Math.max(currentLevel - 1, 0);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    @Override
    public void navigateRight() {
        currentLevel = Math.min(currentLevel + 1, menuLevels.size() - 1);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    @Override
    public void navigateUp() {
        optionSelected = Math.max(optionSelected - 1, 1);
    }

    @Override
    public void navigateDown() {
        optionSelected = Math.min(optionSelected + 1, menuLevels.get(currentLevel).size() - 1);
    }

    // Joe submenu options
    public boolean isSelectedJoeCustomize() {
        return currentLevel == 0;
    }

    public boolean isSelectedJoeCap() {
        return isSelectedOption(0, 1);
    }

    public boolean isSelectedJoeClothes() {
        return isSelectedOption(0, 2);
    }

    public boolean isSelectedJoeVest() {
        return isSelectedOption(0, 3);
    }

    public boolean isSelectedJoeShoes() {
        return isSelectedOption(0, 4);
    }

    // Kids submenu options
    public boolean isSelectedKidsCustomize() {
        return currentLevel == 1;
    }

    public boolean isSelectedKidsShirt() {
        return isSelectedOption(1, 1);
    }

    public boolean isSelectedKidsPants() {
        return isSelectedOption(1, 2);
    }

    public boolean isSelectedKidsBackpack() {
        return isSelectedOption(1, 3);
    }

    public boolean isSelectedKidsShoes() {
        return isSelectedOption(1, 4);
    }

    // Cars submenu options
    public boolean isSelectedCarsCustomize() {
        return currentLevel == 2;
    }

    public boolean isSelectedCarsBody() {
        return isSelectedOption(2, 1);
    }

    public boolean isSelectedOption(int levelIndex, int optionIndex) {
        return isSelectedElement(levelIndex) && optionSelected == optionIndex;
    }

    public boolean isSelectedElement(int levelIndex) {
        return currentLevel == levelIndex;
    }

    public ColorPaletteMenu getColorPaletteMenu() {
        return this.colorPaletteMenu;
    }

    public char getSelectedColorChar() {
        if (isSelectedJoeCap()) selectedColorChar = '<';
        if (isSelectedJoeClothes()) selectedColorChar = '!';
        if (isSelectedJoeVest()) selectedColorChar = '+';
        if (isSelectedJoeShoes()) selectedColorChar = '*';
        if (isSelectedKidsShirt()) selectedColorChar = '\'';
        if (isSelectedKidsBackpack()) selectedColorChar = ')';
        if (isSelectedKidsPants()) selectedColorChar = '(';
        if (isSelectedKidsShoes()) selectedColorChar = '&';
        if (isSelectedCarsBody()) selectedColorChar = '@';
        return this.selectedColorChar;
    }

    public List<Option> getDefinedColors() {
        return this.definedColors;
    }

    public boolean isColorPaletteSelected() {
        return colorPaletteSelected;
    }

    public void setColorPaletteSelected(boolean b) {
        this.colorPaletteSelected = b;
    }

    public void setColorChange(char oldColor, char newColor) {
        this.oldColor = oldColor;
        this.newColor = newColor;
        colorPaletteMenu.resetSelectedColorIndex();
    }

    public char getOldColor() {
        return this.oldColor;
    }

    public char getNewColor() {
        return this.newColor;
    }
}
