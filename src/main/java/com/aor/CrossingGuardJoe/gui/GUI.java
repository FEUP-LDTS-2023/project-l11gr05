package com.aor.CrossingGuardJoe.gui;

import com.aor.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {
    void clearScreen();
    void refreshScreen() throws IOException;
    void setBackgroundColor(String colorHexCode);
    void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight);
    void drawImage(Position position, String[] image);

    void drawText(Position position, String text, String color);

    void drawRoadLines();

    ACTION getNextAction() throws IOException;

    enum ACTION {
        UP, DOWN, LEFT, RIGHT, SELECT, NONE, QUIT;
    }
}
