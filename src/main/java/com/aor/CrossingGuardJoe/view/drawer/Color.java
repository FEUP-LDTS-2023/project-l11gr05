package com.aor.CrossingGuardJoe.view.drawer;

import com.googlecode.lanterna.TextColor;

public enum Color {
    Black(TextColor.Factory.fromString("#000000"), '$'),
    White(TextColor.Factory.fromString("#FFFFFF"), 'W'),
    Skin(TextColor.Factory.fromString("#FFEBB2"), '%'),
    Skin2(TextColor.Factory.fromString("#FFCA8E"), '>'),
    Red(TextColor.Factory.fromString("#FF5451"), '&'),
    Red2(TextColor.Factory.fromString("#FF0000"), 'R'),
    Orange(TextColor.Factory.fromString("#F0922D"), '+'),
    Yellow(TextColor.Factory.fromString("#FFDC1C"), ')'),
    Yellow2(TextColor.Factory.fromString("#F6D756"), '<'),
    Blue(TextColor.Factory.fromString("#447296"), '('),
    Blue2(TextColor.Factory.fromString("#4D9CFD"), '!'),
    Brown(TextColor.Factory.fromString("#601E00"), '*'),
    Purple(TextColor.Factory.fromString("#9E0CFF"), '\'');

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
