package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Color;
import com.CrossingGuardJoe.viewer.Shape;
import com.CrossingGuardJoe.viewer.Text;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.ArrowImages;

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
                Position optionPosition = option.getPosition();

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

                // Draw the options text shadows (black)
                gui.drawImage(optionPosition, option.getImage());

                // Draw the options text (white)
                if (j > 0) {
                    drawOptionTextShadow(gui, option.getPosition(), option.getImage(), -1, "#FFFFFF");
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
            for (int i = 0; i < getModel().getColorPalette().size(); i++) {
                if (getModel(). isColorSelected(i)) {
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
        gui.drawImage(new Position(181, 29), new Text().getTextImage("CUSTOMIZE YOUR GAME"));
        gui.drawImageCustomColor(new Position(180, 28), new Text().getTextImage("CUSTOMIZE YOUR GAME"), "#FFFFFF");
    }

    @Override
    public void drawInformation(GUI gui) {
        gui.drawImage(new Position(5, 5), new Text().getTextImage("ESC"));
        gui.drawImageCustomColor(new Position(4, 4), new Text().getTextImage("ESC"), "#FFFFFF");
    }

    private void drawSelectionBox(GUI gui) {
        gui.drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
        gui.drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
        gui.drawImage(new Position(350, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, 'K', 2, '$'));
    }

    private void drawOptionTextShadow(GUI gui, Position position, String[] image, int bias, String colorHexCode) {
        gui.drawImageCustomColor(new Position(
                        position.getX() + bias, position.getY() + bias),
                image, colorHexCode);
    }

    private void drawElementsColorSquare(GUI gui) {
        for (Option colorSquare : getModel().getDefinedColors()) {
            gui.drawImage(colorSquare.getPosition(), colorSquare.getImage());
        }
    }

    private void drawColorsPalette(GUI gui) {
        int initialXBoard = 52;
        int iniitialXFill = 105;

        for (Color color : getModel().getColorPalette()) {
            gui.setColorHexaCode(color.getColorHexCode());
            gui.fillRectangle(new Position(iniitialXFill, 426), 25, 30);
            gui.drawImage(new Position(initialXBoard, 426), Shape.RectangleFilledGenerator(25, 30, ' ', 1, '$'));

            initialXBoard += 15;
            iniitialXFill += 30;
        }
    }

}
