package com.CrossingGuardJoe.ViewerTest;

import com.CrossingGuardJoe.viewer.images.Font.FontImageFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FontTest {
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

    @Test
    public void testGetImageRepresentationText() {
        FontImageFactory factory = new FontImageFactory();
        String input = "TES T";
        String[] result = factory.getImageRepresentation(input);
        assertArrayEquals(TES_T, result);
    }
}
