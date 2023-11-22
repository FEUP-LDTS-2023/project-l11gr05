package com.aor.CrossingGuardJoe.gui;

import com.aor.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {
    void clearScreen();
    void refreshScreen() throws IOException;
    void setBackgrounColor(String colorHexCode);
    void fillRectangle(Position initialPosition, int rectangleWidth, int rectangleHeight, Character character);

    void drawJoe(Position position);

    void drawKid(Position position);

    void drawCar(Position position);
}
