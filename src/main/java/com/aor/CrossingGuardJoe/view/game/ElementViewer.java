package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.GUI.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.Element;

public abstract class ElementViewer<T extends Element> {
    private GUI gui;

    abstract void draw(T element, GUI gui);

    private void drawImage(Position initialPosition, String[] image) {
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
