package com.aor.CrossingGuardJoe.Viewer;

import com.aor.CrossingGuardJoe.GUI.GUI;
import com.aor.CrossingGuardJoe.Model.Position;
import com.aor.CrossingGuardJoe.Model.game.Element;

public abstract class ElementViewer<T extends Element> {
    private GUI gui;

    protected abstract void draw(T element, GUI gui);

    protected void drawImage(GUI gui, Position initialPosition, String[] image) {
        this.gui = gui;
        int yPos = initialPosition.getY();
        for (String imageLine : image) {
            drawLine(initialPosition.getX(), yPos, imageLine);
            yPos++;
        }
    }

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
            this.gui.fillRectangle(new Position(x + xPos, y),
                    1, 1, ' ');
            xPos++;
        }
    }
}
