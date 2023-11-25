package com.aor.CrossingGuardJoe.viewer;

public enum Color {
    BLACK("#000000", '$'),
    WHITE("#FFFFFF", 'W'),
    SKIN("#FFEBB2", '%'),
    SKIN2("#FFCA8E", '>'),
    RED("#FF5451", '&'),
    RED2("#FF0000", 'R'),
    ORANGE("#F0922D", '+'),
    YELLOW("#FFDC1C", ')'),
    YELLOW2("#F6D756", '<'),
    GREEN("#BAF11C", 'G'),
    BLUE("#447296", '('),
    BLUE2("#4D9CFD", '!'),
    BROWN("#601E00", '*'),
    PURPLE("#9E0CFF", '\''),
    BLUE3("#368CFF", '~'),
    ROASTED_YELLOW("#8E6E43", '@'),
    CYAN("#36CDFF", '='),
    LIGHT_GREY("#C0BBB1", '«'),
    DARK_GREY("#3D3638", '»');

    private String colorHexCode;
    private char character;

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
