package com.CrossingGuardJoe.viewer;

public class Shape {
    public static String[] RectangleFilledGenerator(int width, int height, char character) {
        String[] result = new String[height];

        StringBuilder row = new StringBuilder();
        for (int i = 0; i < width; i++) {
            row.append(character);
        }

        for (int i = 0; i < height; i++) {
            result[i] = row.toString();
        }

        return result;
    }

    public static String[] RectangleFilledGenerator(int width, int height, char character, int boardWidth, char boardChar) {
        String[] result = new String[height];

        StringBuilder innerRow = new StringBuilder();
        for (int i = 0; i < width; i++) {
            innerRow.append(character);
        }

        StringBuilder innerRowWithBorders = new StringBuilder();
        for (int i = 0; i < boardWidth; i++) {
            innerRowWithBorders.append(boardChar);
        }
        innerRowWithBorders.append(innerRow);
        for (int i = 0; i < boardWidth; i++) {
            innerRowWithBorders.append(boardChar);
        }

        String innerRowWithBordersStr = innerRowWithBorders.toString();

        StringBuilder outerRow = new StringBuilder();
        for (int i = 0; i < width + 2 * boardWidth; i++) {
            outerRow.append(boardChar);
        }

        String outerRowStr = outerRow.toString();

        result[0] = outerRowStr;
        for (int i = 1; i < height - 1; i++) {
            result[i] = innerRowWithBordersStr;
        }
        result[height - 1] = outerRowStr;

        return result;
    }
}
