package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ToolImages;
import com.CrossingGuardJoe.viewer.images.defined.LogoImages;

public class MenuViewer extends Viewer<Menu> implements MenuInformationDrawer {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option option = getModel().getOption(i);
            Position optionPosition = option.position();

            //options text
            gui.drawText(optionPosition, option.name(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(optionPosition.getX() - 15, optionPosition.getY()), ToolImages.getArrowRightImage());
            }
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawImage(new Position(130, 50), LogoImages.getLogoGameImage());
    }

    @Override
    public void drawInformation(GUI gui) {}
}
