package com.aor.CrossingGuardJoe.view.drawer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Draw {
    private final TextGraphics graphics;

    public Draw(TextGraphics graphics) {
        this.graphics = graphics;
    }

    private void setColor(char character) {
        Color color = Color.getColor(character);
        if (color != null) {
            graphics.setBackgroundColor(color.getColorText());
        }
    }

    private void drawLine(int x, int y, String imageLine) {
        int xPos = x;
        for (char character : imageLine.toCharArray()) {
            if (character != ' ') {
                setColor(character);
                graphics.fillRectangle(new TerminalPosition(x + xPos, y),
                        new TerminalSize(1, 1), ' ');
            }
            xPos++;
        }
    }

    public void drawImage(int initialX, int initialY, String[] image) {
        int yPos = initialY;
        for (String imageLine : image) {
            drawLine(initialX, yPos, imageLine);
            yPos++;
        }
    }

}
