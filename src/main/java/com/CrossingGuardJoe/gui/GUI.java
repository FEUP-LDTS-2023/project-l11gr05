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
    void drawText(Position position, String text, String colorHexCode);
    void drawNumber(Position position, int number, String colorHexCode);
    void setColorHexaCode(String hexCode);
    void addColorMapping(char oldCharacter, char newCharacter);


    ACTION getNextAction() throws IOException;

    enum ACTION {
        UP, DOWN, LEFT, RIGHT, SELECT, NONE, QUIT, ESC
    }
}
