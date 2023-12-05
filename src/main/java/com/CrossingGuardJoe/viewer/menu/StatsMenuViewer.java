package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;

public class StatsMenuViewer extends Viewer<StatsMenu> implements MenuInformationDrawer {
    public StatsMenuViewer(StatsMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawInformation(gui);
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawText(new Position(207, 100), "Game stats", "#FFFFFF");
    }

    @Override
    public void drawInformation(GUI gui) {
        gui.drawText(new Position(210, 210), "score", "#FFFFFF");
        gui.drawText(new Position(210, 250), "level", "#FFFFFF");
        gui.drawText(new Position(150, 300), "highest score", "#FFFFFF");
        gui.drawText(new Position(150, 340), "highest level", "#FFFFFF");

        gui.drawText(new Position(275, 210), getModel().getCurrentScore(), "#FFFFFF");
        gui.drawText(new Position(275, 250), getModel().getCurrentLevel(), "#FFFFFF");
        gui.drawText(new Position(275, 300), getModel().getHighestScore(), "#FFFFFF");
        gui.drawText(new Position(275, 340), getModel().getHighestLevel(), "#FFFFFF");

        gui.drawImage(new Position(4, 4), ToolImages.KEY_ESC);
    }
}
