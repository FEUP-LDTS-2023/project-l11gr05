package com.CrossingGuardJoe.gui;

import com.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {
    void clearScreen();
    void refreshScreen() throws IOException;
    void closeScreen() throws IOException;
    void setBackgroundColor(String colorHexCode);
    void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight);
    void drawImage(Position position, String[] image);
    void setColorHexaCode(String hexaCode);
    void drawImageCustomColor(Position position, String[] image, String colorHexCode);


    ACTION getNextAction() throws IOException;

    enum ACTION {
        UP, DOWN, LEFT, RIGHT, SELECT, NONE, QUIT
    }
}
