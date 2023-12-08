package com.CrossingGuardJoe.viewer;

import java.util.HashMap;
import java.util.Map;

public class ColorCustomize {
    private static final ColorCustomize instance = new ColorCustomize();
    private final Map<Character, Character> characterMap;

    private ColorCustomize() {
        characterMap = new HashMap<>();
    }

    public static ColorCustomize getInstance() {
        return instance;
    }

    public void addMapping(char fromCharacter, char toCharacter) {
        characterMap.put(fromCharacter, toCharacter);
    }

    public char getMappedCharacter(char character) {
        return characterMap.getOrDefault(character, character);
    }
}
