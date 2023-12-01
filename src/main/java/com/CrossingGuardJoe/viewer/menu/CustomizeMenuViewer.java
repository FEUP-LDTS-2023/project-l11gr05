package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;
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
        gui.drawImage(new Position(5, 5), new Text().getTextImage("ESC"));

        // options draw
        for (int i = 0; i < getModel().getMenuLevels().size(); i++) {
            List<Option> levelOptions = getModel().getMenuLevels().get(i);
            for (int j = 0; j < levelOptions.size(); j++) {
                Option option = levelOptions.get(j);
                Position optionPosition = option.getPosition();

                gui.drawImage(optionPosition, option.getImage());
                if (j > 0) {
                    drawOptionTextShadow(gui, option.getPosition(), option.getImage(), -1, "#FFFFFF");
                }

                // select the column
                if (getModel().isSelectedElement(i)) {
                    gui.drawImage(new Position(levelOptions.get(0).getPosition().getX() - 15,
                            levelOptions.get(0).getPosition().getY()), ArrowImages.ARROW_RIGHT);
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
