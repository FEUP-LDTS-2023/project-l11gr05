package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;

public class GameOverViewer extends Viewer<GameOverMenu> implements MenuInformationDrawer {
    public GameOverViewer(GameOverMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawInformation(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option option = getModel().getOption(i);
            Position optionPosition = option.position();

            //options text
            gui.drawText(new Position(optionPosition.getX(), optionPosition.getY()),
                    option.name(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(optionPosition.getX() - 15, optionPosition.getY()), ToolImages.ARROW_RIGHT);
            }
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        if (getModel().isWin()) {
            gui.drawText(new Position(207, 100), "Congratulations", "#FFFFFF");
        }
        else {
            gui.drawText(new Position(210, 100), "game over", "#FFFFFF");
        }
    }

    @Override
    public void drawInformation(GUI gui) {
        gui.drawText(new Position(210, 210), "score", "#FFFFFF");
        gui.drawText(new Position(210, 250), "level", "#FFFFFF");
        gui.drawText(new Position(275, 210), getModel().getCurrentGame().getJoe().getScore(), "#FFFFFF");
        gui.drawText(new Position(275, 250), getModel().getCurrentGame().getCurrentLevel(), "#FFFFFF");
    }
}
