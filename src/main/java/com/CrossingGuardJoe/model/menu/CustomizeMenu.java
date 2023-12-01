package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.viewer.Shape;
import com.CrossingGuardJoe.viewer.Text;
import com.CrossingGuardJoe.viewer.images.CarImage;
import com.CrossingGuardJoe.viewer.images.JoeImages;
import com.CrossingGuardJoe.viewer.images.KidImages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomizeMenu {
    private final List<List<Option>> menuLevels;
    private final List<Option> definedColors;
    private int currentLevel;
    private int optionSelected;
    private char selectedColorChar;

    public CustomizeMenu() {
        this.menuLevels = new ArrayList<>();
        this.currentLevel = 0;
        this.optionSelected = 1;

        int JOE_X = 100;
        int OPTIONS_Y = 230;
        List<Option> Joe = Arrays.asList(
                new Option(new Position(JOE_X, 100), JoeImages.JOE_STAND),
                new Option(new Position(JOE_X, OPTIONS_Y), new Text().getTextImage("Cap")),
                new Option(new Position(JOE_X, OPTIONS_Y + 30), new Text().getTextImage("Clothes")),
                new Option(new Position(JOE_X, OPTIONS_Y + 60), new Text().getTextImage("Vest")),
                new Option(new Position(JOE_X, OPTIONS_Y + 90), new Text().getTextImage("Shoes"))
        );

        int KIDS_X = 235;
        List<Option> Kids = Arrays.asList(
                new Option(new Position(KIDS_X, 100), KidImages.KID_STAND),
                new Option(new Position(KIDS_X, OPTIONS_Y), new Text().getTextImage("Shirt")),
                new Option(new Position(KIDS_X, OPTIONS_Y + 30), new Text().getTextImage("Pants")),
                new Option(new Position(KIDS_X, OPTIONS_Y + 60), new Text().getTextImage("Backpack")),
                new Option(new Position(KIDS_X, OPTIONS_Y + 90), new Text().getTextImage("Shoes"))
        );

        int CARS_X = 370;
        List<Option> Cars = Arrays.asList(
                new Option(new Position(CARS_X, 100), CarImage.CAR),
                new Option(new Position(CARS_X, OPTIONS_Y + 30), new Text().getTextImage("CAR"))
        );

        menuLevels.add(Joe);
        menuLevels.add(Kids);
        menuLevels.add(Cars);

        this.definedColors = Arrays.asList(
                new Option(new Position(menuLevels.get(0).get(1).getPosition().getX() - 13, menuLevels.get(0).get(1).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '<', 1, '$')),
                new Option(new Position(menuLevels.get(0).get(2).getPosition().getX() - 13, menuLevels.get(0).get(2).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '!', 1, '$')),
                new Option(new Position(menuLevels.get(0).get(3).getPosition().getX() - 13, menuLevels.get(0).get(3).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '+', 1, '$')),
                new Option(new Position(menuLevels.get(0).get(4).getPosition().getX() - 13, menuLevels.get(0).get(4).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '*', 1, '$')),
                new Option(new Position(menuLevels.get(1).get(1).getPosition().getX() - 13, menuLevels.get(1).get(1).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '\'', 1, '$')),
                new Option(new Position(menuLevels.get(1).get(2).getPosition().getX() - 13, menuLevels.get(1).get(2).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, ')', 1, '$')),
                new Option(new Position(menuLevels.get(1).get(3).getPosition().getX() - 13, menuLevels.get(1).get(3).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '(', 1, '$')),
                new Option(new Position(menuLevels.get(1).get(4).getPosition().getX() - 13, menuLevels.get(1).get(4).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '&', 1, '$')),
                new Option(new Position(menuLevels.get(2).get(1).getPosition().getX() - 13, menuLevels.get(2).get(1).getPosition().getY()),
                        Shape.RectangleFilledGenerator(16, 16, '@', 1, '$'))
        );

    }

    public List<List<Option>> getMenuLevels() {
        return this.menuLevels;
    }

    public void navigateLeft() {
        // Move left to a previous level (list of options)
        currentLevel = Math.max(currentLevel - 1, 0);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    public void navigateRight() {
        // Move right to the next level (list of options)
        currentLevel = Math.min(currentLevel + 1, menuLevels.size() - 1);
        optionSelected = Math.min(optionSelected, menuLevels.get(currentLevel).size() - 1);
    }

    public void navigateUp() {
        // Move up within the current level (list of options)
        optionSelected = Math.max(optionSelected - 1, 1);
    }

    public void navigateDown() {
        // Move down within the current level (list of options)
        optionSelected = Math.min(optionSelected + 1, menuLevels.get(currentLevel).size() - 1);
    }

    public Option getCurrentOption() {
        return menuLevels.get(currentLevel).get(optionSelected);
    }

    // Joe submenu options
    public boolean isSelectedJoeCustomize() {
        return currentLevel == 0;
    }

    public boolean isSelectedJoeCap() {
        return isSelectedOption(0, 1); // Assuming Cap is the second option in Joe submenu
    }

    public boolean isSelectedJoeClothes() {
        return isSelectedOption(0, 2); // Assuming Clothes is the third option in Joe submenu
    }

    public boolean isSelectedJoeVest() {
        return isSelectedOption(0, 3); // Assuming Vest is the fourth option in Joe submenu
    }

    public boolean isSelectedJoeShoes() {
        return isSelectedOption(0, 4); // Assuming Shoes is the fifth option in Joe submenu
    }

    // Kids submenu options
    public boolean isSelectedKidsCustomize() {
        return currentLevel == 1;
    }

    public boolean isSelectedKidsShirt() {
        return isSelectedOption(1, 1); // Assuming Shirt is the second option in Kids submenu
    }

    public boolean isSelectedKidsPants() {
        return isSelectedOption(1, 2); // Assuming Pants is the third option in Kids submenu
    }

    public boolean isSelectedKidsBackpack() {
        return isSelectedOption(1, 3); // Assuming Backpack is the fourth option in Kids submenu
    }

    public boolean isSelectedKidsShoes() {
        return isSelectedOption(1, 4); // Assuming Kids Shoes is the fifth option in Kids submenu
    }

    // Cars submenu options
    public boolean isSelectedCarsCustomize() {
        return currentLevel == 2;
    }

    public boolean isSelectedCarsBody() {
        return isSelectedOption(2, 1); // Assuming Body is the second option in Cars submenu
    }

    public boolean isSelectedOption(int levelIndex, int optionIndex) {
        return isSelectedElement(levelIndex) && optionSelected == optionIndex;
    }

    public boolean isSelectedElement(int levelIndex) {
        return currentLevel == levelIndex;
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

}
