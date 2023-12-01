package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.ArrowImages;
import com.CrossingGuardJoe.viewer.images.LogoImages;

public class MenuViewer extends Viewer<Menu> implements InformationDrawer {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option optionSelected = getModel().getOption(i);

            //options shadow
            gui.drawImage(optionSelected.getPosition(), optionSelected.getImage());
            drawOptionTextShadow(gui, optionSelected.getPosition(), optionSelected.getImage(), -1, "#000000");

            //options text
            drawOptionTextShadow(gui, optionSelected.getPosition(), optionSelected.getImage(), -2, "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(
                                getModel().getOption(getModel().getOptionSelected()).getPosition().getX() - 15,
                                getModel().getOption(getModel().getOptionSelected()).getPosition().getY()),
                        ArrowImages.ARROW_RIGHT);
            }
        }
    }

    private void drawOptionTextShadow(GUI gui, Position position, String[] image, int bias, String colorHexCode) {
        gui.drawImageCustomColor(new Position(
                        position.getX() + bias, position.getY() + bias),
                image, colorHexCode);
    }

    @Override
    public void drawTitle(GUI gui) {
        gui.drawImage(new Position(130, 50), LogoImages.LOGO_GAME);
    }

    @Override
    public void drawInformation(GUI gui) {}
}
