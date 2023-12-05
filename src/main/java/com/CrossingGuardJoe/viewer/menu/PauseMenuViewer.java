package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;

public class PauseMenuViewer extends Viewer<PauseMenu> implements MenuInformationDrawer {

    public PauseMenuViewer(PauseMenu pauseMenu) {
        super(pauseMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option option = getModel().getOption(i);
            Position optionPosition = option.position();

            //options shadow
            gui.drawText(optionPosition, option.name(), "#000000");

            //options text
            gui.drawText(new Position(optionPosition.getX() - 1, optionPosition.getY() - 1),
                    option.name(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(optionPosition.getX() - 15, optionPosition.getY()), ToolImages.ARROW_RIGHT);
            }
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawText(new Position(208, 102), "Game paused", "#000000");
        gui.drawText(new Position(208, 101), "Game paused", "#000000");
        gui.drawText(new Position(207, 100), "Game paused", "#FFFFFF");
    }

    @Override
    public void drawInformation(GUI gui) {

    }
}
