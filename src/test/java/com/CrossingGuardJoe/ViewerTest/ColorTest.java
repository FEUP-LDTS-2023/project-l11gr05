package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.viewer.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    void testGetColorHexCode() {
        assertEquals("#000000", Color.BLACK.getColorHexCode());
        assertEquals("#FFFFFF", Color.WHITE.getColorHexCode());
    }

    @Test
    void testGetCharacter() {
        assertEquals('R', Color.RED2.getCharacter());
        assertEquals('!', Color.BLUE2.getCharacter());
    }

    @Test
    void testGetColor() {
        assertEquals(Color.PURPLE, Color.getColor('\''));
        assertEquals(Color.ORANGE, Color.getColor('+'));
    }

    @Test
    void testAllColors() {
        for (Color color : Color.values()) {
            Color colorGet = Color.getColor(color.getCharacter());
            Assertions.assertEquals(color, colorGet);
        }
    }

    @Test
    void testNullColor() {
        Color color = Color.getColor('ç');
        Assertions.assertNull(color);
    }
}
