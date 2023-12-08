package com.CrossingGuardJoe.ModelTest.menu;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionTest {

    @Test
    public void testOptionConstructorAndGetters() {
        Position position = new Position(5, 10);
        String[] image = {"###", "###", "###"};

        Option option = new Option("Sample Option", position, image);

        // Test constructor and getters
        assertEquals("Sample Option", option.name());
        assertEquals(position, option.position());
        assertArrayEquals(image, option.image());
    }
}