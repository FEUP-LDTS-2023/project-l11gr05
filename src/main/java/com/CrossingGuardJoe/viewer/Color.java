package com.CrossingGuardJoe.viewer;

public enum Color {

    BLACK("#000000", '$'),
    DARK_GREY("#3D3638", 'L'),
    BACKGROUND("#7F7976", 'A'),
    LIGHT_GREY("#C0BBB1", 'K'),
    WHITE("#FFFFFF", 'W'),
    SKIN("#FFEBB2", '%'),
    SKIN2("#FFCA8E", '>'),
    ORANGE("#F0922D", '+'),
    RED("#FF5451", '&'),
    RED2("#FF0000", 'R'),
    ORANGE2("#F36849", 'O'),
    ROASTED_YELLOW("#8E6E43", '@'),
    YELLOW2("#F6D756", '<'),
    YELLOW("#FFDC1C", ')'),
    YELLOW3("#FFDB00", 'q'),
    GREEN("#BAF11C", 'G'),
    GREEN3("#66B032", 'u'),
    GREEN2("#6C9772", 'g'),
    DARK_GREEN("#0E3B2C", 'v'),
    CYAN("#36CDFF", '='),
    BLUE("#447296", '('),
    BLUE2("#4D9CFD", '!'),
    BLUE3("#368CFF", '~'),
    DARK_BLUE("#193364", 'B'),
    BROWN("#601E00", '*'),
    PURPLE("#9E0CFF", '\''),
    PINK("#F85DC6", 'P');

    private final String colorHexCode;
    private final char character;

    Color(String colorHexCode, char character) {
        this.colorHexCode = colorHexCode;
        this.character = character;
    }

    public String getColorHexCode() {
        return this.colorHexCode;
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
}
