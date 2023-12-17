package com.CrossingGuardJoe.viewer.images.Font;

public class FontImageFactory {
    public FontImageFactory() {}

    public String[] getImageRepresentation(Object input) {
        if (input instanceof String) {
            return getTextImage((String) input);
        } else if (input instanceof Integer || input instanceof Long || input instanceof Short) {
            return getNumberImage((int) input);
        } else {
            throw new IllegalArgumentException("Unsupported input type");
        }
    }

    private String[] getTextImage(String text) {
        StringBuilder[] result = new StringBuilder[16];

        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            String[] characterToAppend;
            if (character == ' ') {
                characterToAppend = FontImages.getSpaceImage();
            } else {
                characterToAppend = new String[16];
                int characterIndex = getAlphabetIndex(character);
                for (int j = characterIndex * 16; j < (characterIndex + 1) * 16; j++) {
                    String line = FontImages.getAlphabetImage()[j % FontImages.getAlphabetImage().length];
                    characterToAppend[j - characterIndex * 16] = line;
                }
            }

            for (int j = 0; j < characterToAppend.length; j++) {
                result[j].append(characterToAppend[j]);
            }
        }

        String[] output = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            output[i] = result[i].toString();
        }

        return output;
    }

    private String[] getNumberImage(int number) {
        String numberString = Integer.toString(number);

        StringBuilder[] result = new StringBuilder[16];

        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < numberString.length(); i++) {
            Character character = numberString.charAt(i);
            String[] characterToAppend;

            characterToAppend = new String[16];
            int characterIndex = Character.getNumericValue(character);
            for (int j = characterIndex * 16; j < (characterIndex + 1) * 16; j++) {
                String line = FontImages.getNumbersImage()[j % FontImages.getNumbersImage().length];
                characterToAppend[j - characterIndex * 16] = line;
            }

            for (int j = 0; j < characterToAppend.length; j++) {
                result[j].append(characterToAppend[j]);
            }
        }

        String[] output = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            output[i] = result[i].toString();
        }

        return output;
    }

    private int getAlphabetIndex(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c);
        }
        return c - 'A';
    }
}
