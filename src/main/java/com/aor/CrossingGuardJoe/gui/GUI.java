package com.aor.CrossingGuardJoe.gui;

import com.aor.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {
    void clearScreen();
    void refreshScreen() throws IOException;
    void setBackgroundColor(String colorHexCode);
    void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight, Character character);
    void drawImage(Position position, String[] image);

    void drawText(Position position, String text, String color);

    ACTION getNextAction() throws IOException;

    enum ACTION {
        UP, DOWN, LEFT, RIGHT, PASS, STOP, SELECT, NONE, QUIT;
    }
}
