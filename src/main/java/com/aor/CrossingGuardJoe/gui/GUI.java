package com.aor.CrossingGuardJoe.gui;

import com.aor.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {
    void clearScreen();
    void refreshScreen() throws IOException;
    void setBackgrounColor(String colorHexCode);
    void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight, Character character);
    void drawImage(Position position, String[] image);


    ACTION getNextAction() throws IOException;
    enum ACTION {
        LEFT, RIGHT, PASS, STOP, SELECT, NONE, QUIT;
    }
}
