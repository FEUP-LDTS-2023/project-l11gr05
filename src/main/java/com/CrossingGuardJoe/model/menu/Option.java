package com.CrossingGuardJoe.model.menu;

import com.CrossingGuardJoe.model.Position;

public class Option {
    private final String text;
    private final Position position;
    private final String[] image;

    public Option(String text, Position position, String[] image) {
        this.text = text;
        this.position = position;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public Position getPosition() {
        return position;
    }

    public String[] getImage() {
        return image;
    }
}
