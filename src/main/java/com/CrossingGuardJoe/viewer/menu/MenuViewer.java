package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.model.menu.Option;
import com.CrossingGuardJoe.viewer.Text;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.images.ArrowImages;
import com.CrossingGuardJoe.viewer.images.LogoImages;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawImage(new Position(130, 50), LogoImages.LOGO_GAME);

        for (int i = 0; i < getModel().getNumberOptions(); i++) {
            Option optionSelected = getModel().getOption(i);

            //option image shadow
            gui.drawImage(optionSelected.getPosition(), optionSelected.getImage());
            gui.drawImageCustomColor(new Position(
                            optionSelected.getPosition().getX() - 1, optionSelected.getPosition().getY() - 2),
                    optionSelected.getImage(), "#000000");

            //option image text
            gui.drawImageCustomColor(new Position(
                    optionSelected.getPosition().getX() - 2, optionSelected.getPosition().getY() - 2),
                    optionSelected.getImage(), "#FFFFFF");

            if (getModel().isSelectedOption(i)) {
                gui.drawImage(new Position(
                                getModel().getOption(getModel().getOptionSelected()).getPosition().getX() - 15,
                                getModel().getOption(getModel().getOptionSelected()).getPosition().getY()),
                        ArrowImages.ARROW_RIGHT);
            }
        }

    }
}
