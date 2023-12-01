package com.CrossingGuardJoe.viewer;

public class Shape {
    public static String[] RectangleGenerator(int width, int height, char character) {
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
}
