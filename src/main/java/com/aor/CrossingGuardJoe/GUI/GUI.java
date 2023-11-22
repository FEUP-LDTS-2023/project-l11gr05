package com.aor.CrossingGuardJoe.GUI;

import com.aor.CrossingGuardJoe.model.Position;

import java.io.IOException;

public interface GUI {

    void clearScreen();
    void refreshScreen() throws IOException;
    void setBackgrounColor(String colorHexCode);
    void fillRectangle(Position initialPosition, Position finalPosition, Character character);
}
