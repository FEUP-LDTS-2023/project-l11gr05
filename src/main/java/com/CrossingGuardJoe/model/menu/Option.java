package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;

public class Option {
    private final String name;
    private final Position position;
    private final String[] image;

    public Option(String name, Position position, String[] image) {
        this.name = name;
        this.position = position;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return position;
    }

    public String[] getImage() {
        return image;
    }
}
