package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> implements MenuInformationDrawer {
    public InstructionsMenuViewer(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawInformation(gui);
        if (getModel().getCurrentPage() == 1) {
            drawPageOne(gui);
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawText(new Position(203, 29), "Instructions", "#000000");
        gui.drawText(new Position(202, 28), "Instructions", "#FFFFFF");

    }

    @Override
    public void drawInformation(GUI gui) {
        int PAGES_INI_X = 400;
        int PAGES_Y = 480;
        //shadows
        gui.drawText(new Position(PAGES_INI_X + 1, PAGES_Y + 1), "Page", "#000000");
        gui.drawText(new Position(PAGES_INI_X + 40 + 1, PAGES_Y + 1), getModel().getCurrentPage(), "#000000");
        gui.drawText(new Position(PAGES_INI_X + 54 + 1, PAGES_Y + 1), "of", "#000000");
        gui.drawText(new Position(PAGES_INI_X + 74 + 1, PAGES_Y + 1), getModel().getTotalPages(), "#000000");

        //text
        gui.drawText(new Position(PAGES_INI_X, PAGES_Y), "Page", "#FFFFFF");
        gui.drawText(new Position(PAGES_INI_X + 40, PAGES_Y), getModel().getCurrentPage(), "#FFFFFF");
        gui.drawText(new Position(PAGES_INI_X + 54, PAGES_Y), "of", "#FFFFFF");
        gui.drawText(new Position(PAGES_INI_X + 74, PAGES_Y), getModel().getTotalPages(), "#FFFFFF");
    }

    private void drawPageOne(GUI gui) {
        drawTitle(gui);

        gui.drawText(new Position(50 + 1, 100 + 1), "you are Joe", "#000000");
        gui.drawText(new Position(70 + 1, 120 + 1), "a crossing guard", "#000000");

        gui.drawText(new Position(50, 100), "you are Joe", "#FFFFFF");
        gui.drawText(new Position(70, 120), "a crossing guard", "#FFFFFF");
        int JOE_Y = 190;

        gui.drawImage(new Position(150, JOE_Y), JoeImages.JOE_STAND);
        gui.drawImage(new Position(230, JOE_Y), JoeImages.JOE_WALKLEFT);
        gui.drawImage(new Position(310, JOE_Y), JoeImages.JOE_WALKRIGHT);

        int KEY_Y = 310;
        gui.drawImage(new Position(235, KEY_Y), ToolImages.KEY_ESC);
        gui.drawImage(new Position(315, KEY_Y), ToolImages.KEY_ESC);
    }
}
