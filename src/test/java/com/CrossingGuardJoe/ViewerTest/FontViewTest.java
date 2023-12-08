package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FontViewTest {
    FontImageFactory factory;

    String[] TES_T = new String[]{
            "$$$$$$$$$$$$     $$$$$$$$$$$       $$$$$$$$$                    $$$$$$$$$$$$    ",
            "$$$$$$$$$$$$    $$$$$$$$$$$$$    $$$$$$$$$$$                    $$$$$$$$$$$$    ",
            "$    $$    $    $$$$      $$$   $$$        $                    $    $$    $    ",
            "     $$         $$$             $$                                   $$         ",
            "     $$         $$$             $$                                   $$         ",
            "     $$         $$$             $$$                                  $$         ",
            "     $$         $$$$$$$$$$      $$$                                  $$         ",
            "     $$         $$$$$$$$$$       $$$$$$$$$                           $$         ",
            "     $$         $$$$$$$$$$        $$$$$$$$$$                         $$         ",
            "     $$         $$$                      $$$                         $$         ",
            "     $$         $$$                       $$$                        $$         ",
            "     $$         $$$                        $$                        $$         ",
            "     $$         $$$        $$   $         $$$                        $$         ",
            "     $$         $$$$      $$$   $$$     $$$$$                        $$         ",
            "    $$$$        $$$$$$$$$$$$$   $$$$$$$$$$$$                        $$$$        ",
            "   $$$$$$        $$$$$$$$$$$    $$$$$$$$$$                         $$$$$$       "
    };

    String[] ONE_HUNDREAD_TWENTY_FIVE = new String[]{
            "     $$$          $$$$$$$$$     $$$$$$$$$$$$$   ",
            "     $$$         $$$$$$$$$$$    $$$$$$$$$$$$$   ",
            "    $$$$        $$$$     $$$$   $$$$$$$$$$$     ",
            "   $$$$$        $$$       $$$   $$$             ",
            "   $$$$$        $$       $$$$   $$$             ",
            "     $$$        $$      $$$$    $$$             ",
            "     $$$               $$$$     $$$$$$$$$$      ",
            "     $$$              $$$$       $$$$$$$$$$     ",
            "     $$$             $$$$          $$$$$$$$$    ",
            "     $$$            $$$$                 $$$$   ",
            "     $$$           $$$$                   $$$   ",
            "     $$$          $$$$          $          $$   ",
            "     $$$         $$$$           $$$       $$$   ",
            "  $$$$$$$$$     $$$$$$$$$$$     $$$$     $$$$   ",
            "$$$$$$$$$$$$$   $$$$$$$$$$$$$    $$$$$$$$$$$$   ",
            "$$$$$$$$$$$$$   $$$$$$$$$$$$$     $$$$$$$$$     ",
    };

    @BeforeEach
    void init() {
        factory = new FontImageFactory();
    }
    @Test
    void textImage() {
        String input = "TES T";
        String[] result = factory.getImageRepresentation(input);
        assertArrayEquals(TES_T, result);
    }

    @Test
    void numberImage() {
        int input = 125;
        String[] result = factory.getImageRepresentation(input);
        assertArrayEquals(ONE_HUNDREAD_TWENTY_FIVE, result);
    }

    @Test
    public void testUnsupportedInputType() {
        FontImageFactory factory = new FontImageFactory();

        boolean unsupportedInput = true;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.getImageRepresentation(unsupportedInput);
        });

        String expectedMessage = "Unsupported input type";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
