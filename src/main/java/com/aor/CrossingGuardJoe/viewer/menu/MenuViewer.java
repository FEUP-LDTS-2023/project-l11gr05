package com.aor.CrossingGuardJoe.viewer.menu;

import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(500, 500), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberOptions(); i++)
            gui.drawText(
                    new Position(50, 70 + i),
                    getModel().getOption(i),
                    getModel().selectedOption(i) ? "#FFD700" : "#FFFFFF");
    }
}
