package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.defined.ArrowImages;
import com.CrossingGuardJoe.viewer.images.defined.LogoImages;

public class MenuViewer extends Viewer<Menu> implements InformationDrawer {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option option = getModel().getOption(i);
            Position optionPosition = option.position();

            //options shadow
            gui.drawText(optionPosition, option.name(), "#000000");
            gui.drawText(new Position(optionPosition.getX() - 1, optionPosition.getY() - 1),
                    option.name(), "#000000");

            //options text
            gui.drawText(new Position(optionPosition.getX() - 2, optionPosition.getY() - 2),
                    option.name(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(optionPosition.getX() - 15, optionPosition.getY()), ArrowImages.ARROW_RIGHT);
            }
        }
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawImage(new Position(130, 50), LogoImages.LOGO_GAME);
    }

    @Override
    public void drawInformation(GUI gui) {}
}
