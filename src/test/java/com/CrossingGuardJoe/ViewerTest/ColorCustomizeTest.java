package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.viewer.ColorCustomize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorCustomizeTest {
    private ColorCustomize colorCustomize;

    @BeforeEach
    void setUp() {
        colorCustomize = ColorCustomize.getInstance();
    }

    @Test
    void testAddMapping() {
        colorCustomize.addMapping('A', 'B');
        char mappedCharacter = colorCustomize.getMappedCharacter('A');
        assertEquals('B', mappedCharacter);
    }

    @Test
    void testGetMappedCharacter() {
        colorCustomize.addMapping('X', 'Y');
        colorCustomize.addMapping('1', '2');

        char mappedCharacterX = colorCustomize.getMappedCharacter('X');
        char mappedCharacter1 = colorCustomize.getMappedCharacter('1');
        char unmappedCharacter = colorCustomize.getMappedCharacter('Z');
        assertEquals('Y', mappedCharacterX);
        assertEquals('2', mappedCharacter1);
        assertEquals('Z', unmappedCharacter);
    }
}
