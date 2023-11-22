package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.GUI.GUI;
import com.aor.CrossingGuardJoe.model.game.Element;
import com.aor.CrossingGuardJoe.view.drawer.Color;

public abstract class ElementViewer<T extends Element> {
    private GUI gui;
    abstract void draw(T element, GUI gui);

    private void setColor(char character) {
        Color color = Color.getColor(character);
        if (color != null) {
            this.gui.setBackgrounColor(color.getColorText());
        }
    }

    private void drawLine(int x, int y, String imageLine) {
        int xPos = x;
        for (char character : imageLine.toCharArray()) {
            setColor(character);
            this.gui.
        }
    }

}
