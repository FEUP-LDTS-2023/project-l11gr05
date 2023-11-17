package com.aor.CrossingGuardJoe.view.drawer;

import com.googlecode.lanterna.TextColor;

public enum Color {
    Black(TextColor.Factory.fromString("#000000"), '$'),
    Skin(TextColor.Factory.fromString("#FFEBB2"), '%'),
    Purple(TextColor.Factory.fromString("#9E0CFF"), '\''),
    Yellow(TextColor.Factory.fromString("#FFDC1C"), ')'),
    Blue(TextColor.Factory.fromString("#447296"), '('),
    Red(TextColor.Factory.fromString("#FF5451"), '&');




    private TextColor color;
    private char character;

    Color(TextColor color, char character) {
        this.color = color;
        this.character = character;
    }

    Color() {}

    public TextColor getTextColor() {
        return this.color;
    }

    public char getCharacter() {
        return this.character;
    }
    public static Color getColor(char character) {
        for (Color color : Color.values()) {
            if (color.getCharacter() == character) {
                return color;
            }
        }
        return null;
    }

    public TextColor getColorText() {
        return this.color;
    }




}
