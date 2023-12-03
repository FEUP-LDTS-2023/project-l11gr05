package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.*;
import com.CrossingGuardJoe.viewer.images.defined.ArrowImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;

import java.util.List;

public class CustomizeMenuViewer extends Viewer<CustomizeMenu> implements InformationDrawer {
    private final int SELECTION_BOX_WIDTH = 235;
    private final int SELECTION_BOX_HEIGHT = 300;
    public CustomizeMenuViewer(CustomizeMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawInformation(gui);
        drawSelectionBox(gui);

        for (int i = 0; i < getModel().getMenuLevels().size(); i++) {

            List<Option> levelOptions = getModel().getMenuLevels().get(i);

            for (int j = 0; j < levelOptions.size(); j++) {

                Option option = levelOptions.get(j);
                Position optionPosition = option.position();

                // Column selected box drawer (green)
                if (getModel().isSelectedElement(i)) {
                    if (getModel().isSelectedJoeCustomize()) {
                        gui.drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, ' ', 2, 'G'));
                    }
                    else if (getModel().isSelectedKidsCustomize()) {
                        gui.drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, ' ', 2, 'G'));
                    }
                    else if (getModel().isSelectedCarsCustomize()) {
                        gui.drawImage(new Position(350, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, ' ', 2, 'G'));
                    }
                }

                // Draw the options images (Joe, Kid and Car) and the text shadows (black)
                gui.drawImage(optionPosition, option.image());

                // Draw the options text (white)
                if (j > 0) {
                    gui.drawText(new Position(optionPosition.getX() - 1, optionPosition.getY() - 1),
                            option.name(), "#FFFFFF");
                }

                // Draw the selection arrow (green)
                if (getModel().isSelectedOption(i, j)) {
                    gui.drawImage(new Position(optionPosition.getX() - 30, optionPosition.getY()), ArrowImages.ARROW_RIGHT);
                }
            }
        }

        drawElementsColorSquare(gui);
        drawColorsPalette(gui);

        if (getModel().isColorPaletteSelected()) {
            for (int i = 0; i < getModel().getColorPaletteMenu().getColorPalette().size(); i++) {
                if (getModel().getColorPaletteMenu().isColorSelected(i)) {
                    gui.drawImage(new Position(15 * i + 55, 405), ArrowImages.ARROW_DOWN);
                }
            }
        }

        char oldColor = getModel().getOldColor();
        char newColor = getModel().getNewColor();
        if (oldColor != '\uFFFF') {
            gui.addColorMapping(oldColor, newColor);
        }

    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawText(new Position(181, 29),"CUSTOMIZE YOUR GAME", "#000000");
        gui.drawText(new Position(180, 28), "CUSTOMIZE YOUR GAME", "#FFFFFF");
    }

    @Override
    public void drawInformation(GUI gui) {
        gui.drawText(new Position(5, 5), "ESC", "#000000");
        gui.drawText(new Position(4, 4), "ESC", "#FFFFFF");
    }

    private void drawSelectionBox(GUI gui) {
        gui.drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
        gui.drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
        gui.drawImage(new Position(350, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
    }

    private void drawElementsColorSquare(GUI gui) {
        for (Option colorSquare : getModel().getDefinedColors()) {
            gui.drawImage(colorSquare.position(), colorSquare.image());
        }
    }

    private void drawColorsPalette(GUI gui) {
        int initialXBoard = 52;
        int iniitialXFill = 105;

        for (Color color : getModel().getColorPaletteMenu().getColorPalette()) {
            gui.setColorHexaCode(color.getColorHexCode());
            gui.fillRectangle(new Position(iniitialXFill, 426), 25, 30);
            gui.drawImage(new Position(initialXBoard, 426), Shape.RectangleFilledGenerator(25, 30, ' ', 1, '$'));

            initialXBoard += 15;
            iniitialXFill += 30;
        }
    }

}
