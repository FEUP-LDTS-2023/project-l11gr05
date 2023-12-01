package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Shape;
import com.CrossingGuardJoe.viewer.Text;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.ArrowImages;

import java.util.List;

public class CustomizeMenuViewer extends Viewer<CustomizeMenu> {
    public CustomizeMenuViewer(CustomizeMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        //title
        gui.drawImage(new Position(180, 15), new Text().getTextImage("CUSTOMIZE YOUR GAME"));
        gui.drawImageCustomColor(new Position(179, 14), new Text().getTextImage("CUSTOMIZE YOUR GAME"), "#FFFFFF");

        //ESC instruction
        gui.drawImage(new Position(5, 5), new Text().getTextImage("ESC"));
        gui.drawImageCustomColor(new Position(4, 4), new Text().getTextImage("ESC"), "#FFFFFF");

        int SELECTION_BOX_WIDTH = 235;
        int SELECTION_BOX_HEIGHT = 300;
        gui.drawImage(new Position(40, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, '«', 2, '$'));
        gui.drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, '«', 2, '$'));
        gui.drawImage(new Position(350, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, '«', 2, '$'));

        // options draw
        for (int i = 0; i < getModel().getMenuLevels().size(); i++) {
            List<Option> levelOptions = getModel().getMenuLevels().get(i);
            for (int j = 0; j < levelOptions.size(); j++) {

                // select the column
                if (getModel().isSelectedElement(i)) {
                    if (getModel().isSelectedCarsCustomize()) {
                        gui.drawImage(new Position(195, 70), Shape.RectangleFilledGenerator(SELECTION_BOX_WIDTH, SELECTION_BOX_HEIGHT, ' ', 2, 'G'));
                    }
                }

                Option option = levelOptions.get(j);
                Position optionPosition = option.getPosition();

                gui.drawImage(optionPosition, option.getImage());

                if (j > 0) {
                    drawOptionTextShadow(gui, option.getPosition(), option.getImage(), -2, "#FFFFFF");
                }

                //select every specific option
                if (getModel().isSelectedOption(i, j)) {
                    gui.drawImage(new Position(optionPosition.getX() - 30, optionPosition.getY()), ArrowImages.ARROW_RIGHT);
                }
            }
        }

        // elements color square
        for (Option colorSquare : getModel().getDefinedColors()) {
            gui.drawImage(colorSquare.getPosition(), colorSquare.getImage());
        }
    }

    private void drawOptionTextShadow(GUI gui, Position position, String[] image, int bias, String colorHexCode) {
        gui.drawImageCustomColor(new Position(
                        position.getX() + bias, position.getY() + bias),
                image, colorHexCode);
    }

}
