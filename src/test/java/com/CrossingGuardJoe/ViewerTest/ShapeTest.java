package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.viewer.images.generator.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShapeTest {
    @Test
    public void testRectangleFilledGenerator() {
        int width = 5;
        int height = 4;
        char character = 'X';
        int boardWidth = 1;
        char boardChar = '#';

        String[] expected = {
                "#######",
                "#XXXXX#",
                "#XXXXX#",
                "#######"
        };

        String[] result = Shape.RectangleFilledGenerator(width, height, character, boardWidth, boardChar);

        assertArrayEquals(expected, result);
    }
}
