package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;

public class Option {
    private final Position position;
    private final String[] image;

    public Option(Position position, String[] image) {
        this.position = position;
        this.image = image;
    }

    public Position getPosition() {
        return position;
    }

    public String[] getImage() {
        return image;
    }
}
