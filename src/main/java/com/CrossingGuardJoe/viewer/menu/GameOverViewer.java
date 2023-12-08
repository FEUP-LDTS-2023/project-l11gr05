package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;
import com.CrossingGuardJoe.viewer.images.generator.Shape;

public class GameOverViewer extends Viewer<GameOverMenu> implements MenuInformationDrawer {
    public GameOverViewer(GameOverMenu model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        drawInformation(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option option = getModel().getOption(i);
            Position optionPosition = option.position();

            //options text
            gui.drawText(optionPosition, option.name(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(optionPosition.getX() - 15, optionPosition.getY()), ToolImages.ARROW_RIGHT);
            }
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        if (getModel().isWin()) {
            gui.drawText(new Position(187, 80), "Congratulations", "#FFFFFF");
        }
        else {
            gui.drawText(new Position(213, 80), "game over", "#FFFFFF");
        }
    }

    @Override
    public void drawInformation(GUI gui) {
        gui.drawImage(new Position(170, 154), Shape.RectangleFilledGenerator(305, 70, 'K', 2, '$'));
        gui.drawText(new Position(210, 165), "score", "#FFFFFF");
        gui.drawText(new Position(210, 195), "level", "#FFFFFF");
        gui.drawText(new Position(275, 165), getModel().getCurrentGame().getJoe().getScore(), "#FFFFFF");

        if (getModel().getCurrentGame().getCurrentLevel() == 10) {
            gui.drawText(new Position(275, 195), getModel().getCurrentGame().getCurrentLevel(), "#D30000");
        } else {
            gui.drawText(new Position(275, 195), getModel().getCurrentGame().getCurrentLevel(), "#FFFFFF");
        }

    }
}
