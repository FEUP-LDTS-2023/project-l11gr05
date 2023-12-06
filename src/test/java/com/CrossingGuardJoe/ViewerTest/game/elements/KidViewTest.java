package com.CrossingGuardJoe.ViewerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.viewer.game.elements.CarView;
import com.CrossingGuardJoe.viewer.game.elements.KidView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KidViewTest {

    Kid kid;
    GUI gui;
    Position position;
    KidView kidView;

    String[] KIDSTAND_IMAGE = new String[]{
            "                    $$$$$                         ",
            "                 $$$$$$$$$                        ",
            "                $$$$$$$$$$$$                      ",
            "               $$$$$$$$$$$$$$                     ",
            "              $$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$%%$$$$$$$$$$                   ",
            "               $%%%%%$$$$$$$$$$                   ",
            "               $%%%%%$$$$$$$$$$                   ",
            "               $%%%%%%%%$$$$$$$                   ",
            "               $%%%%%%%%$$$$$$                    ",
            "               $%%%%%%%%$$$$$$                    ",
            "               $$%%%%%%%$$$$$                     ",
            "                $%%%%%%%$$$                       ",
            "                $$%%%%%%$$$                       ",
            "                 $$$$%$$$$$$                      ",
            "                    $$$))))$$                     ",
            "                    $$))))))$$                    ",
            "                    $$$$$$$))$                    ",
            "                   $$$'$''$$)$$                   ",
            "                   $$''$'''$))$$$                 ",
            "                  $$''$$'''$$)))$$$               ",
            "                  $'''$'''''$)))))$               ",
            "                  $'''$'''''$))))$$               ",
            "                  $'''$$$$$$$)))))$               ",
            "                  $''''$%%%$$)))))$               ",
            "                  $''''$%%%$$)))))$               ",
            "                  $''''$%%%$$)))))$$              ",
            "                  $''''$%%%$$)))$$)$              ",
            "                  $'''$$%%%$$))))))$$             ",
            "                  $'''$%%%%$$)))))))$             ",
            "                  $'''$%%%%$$)))$$))$             ",
            "                  $'''$%%%$$$)))$$)$$             ",
            "                  $''$$%%%$'$))$$$$$              ",
            "                  $''$%%%$$'$))$                  ",
            "                  $$$%%%$$''$$$$                  ",
            "                  $$%%%$$$$$$                     ",
            "                  $%%%$$(((($                     ",
            "                  $%%%$((((($                     ",
            "                  $$$$$((((($                     ",
            "                  $((((((((($                     ",
            "                  $((((((((($                     ",
            "                  $((((((((($                     ",
            "                  $(((((((((($                    ",
            "                   $((((((((($                    ",
            "                   $((((((((($                    ",
            "                   $((((((((($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                   $(((((($(($                    ",
            "                  $$$$$$$$$$$$$                   ",
            "                 $$&&&&&&&&$&&$$                  ",
            "                $&&&&&&&&&&$&&&$                  ",
            "                $&&&&&&&&&&$&&$$                  ",
            "                $&&&&&&&&&&$&&$                   ",
            "                $$$$$$$$$$$$$$$                   ",
    };

    String[] KIDWALK_IMAGE = new String[] {
            "                    $$$$$                         ",
            "                 $$$$$$$$$                        ",
            "                $$$$$$$$$$$$                      ",
            "               $$$$$$$$$$$$$$                     ",
            "              $$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$$$$$$$$$$$$$                   ",
            "             $$$$$$%%$$$$$$$$$$                   ",
            "               $%%%%%$$$$$$$$$$                   ",
            "               $%%%%%$$$$$$$$$$                   ",
            "               $%%%%%%%%$$$$$$$                   ",
            "               $%%%%%%%%$$$$$$                    ",
            "               $%%%%%%%%$$$$$$                    ",
            "               $$%%%%%%%$$$$$                     ",
            "                $%%%%%%%$$$                       ",
            "                $$%%%%%%$$$                       ",
            "                 $$$$%$$$$$$                      ",
            "                    $$$))))$$                     ",
            "                    $$))))))$$                    ",
            "                    $$$$$$$))$                    ",
            "                   $$$'$''$$)$$                   ",
            "                   $$''$'''$))$$$                 ",
            "                  $$''$$'''$$)))$$$               ",
            "                  $'''$'''''$)))))$               ",
            "                  $'''$'''''$))))$$               ",
            "                  $'''$$$$$$$)))))$               ",
            "                  $''''$%%%$$)))))$               ",
            "                  $''''$%%%$$)))))$               ",
            "                  $''''$%%%$$)))))$$              ",
            "                  $''''$%%%$$)))$$)$              ",
            "                  $'''$$%%%$$))))))$$             ",
            "                  $'''$%%%%$$)))))))$             ",
            "                  $'''$%%%%$$)))$$))$             ",
            "                  $'''$%%%$$$)))$$)$$             ",
            "                  $''$$%%%$'$))$$$$$              ",
            "                  $''$%%%$$'$))$                  ",
            "                  $$$%%%$$''$$$$                  ",
            "                  $$%%%$$$$$$                     ",
            "                  $%%%$$(((($                     ",
            "                  $%%%$((((($                     ",
            "                 $$$$$$((((($$                    ",
            "                 $((((((((((($                    ",
            "                 $((((((((((($$                   ",
            "                $$(((((((((((($                   ",
            "                $(((((((((((((($                  ",
            "               $$((((((($(((((($$                 ",
            "               $((((((($$((((((($                 ",
            "              $$((((((($(((((((($$                ",
            "              $((((((($$$(((((((($                ",
            "             $$(((((($$ $(((((((($$               ",
            "            $$(((((($$   $(((((((($               ",
            "           $$(((((($$     $((((((($$              ",
            "           $((((((($       $((((((($$             ",
            "          $$(((((($$        $$(((((($$            ",
            "          $(((((($$          $$(((((($$           ",
            "         $$(((((($            $$$((((($$          ",
            "         $(((((($               $$((((($$         ",
            "        $$(((((($                $$(((((($$$$     ",
            "       $$(((((($                  $$((($$$&&$     ",
            "     $$$((((((($                   $((($&&&&$     ",
            "     $$$$$$$$$$$                   $$($&&&&&$     ",
            "     $&&&&&&&&&$                    $$$&&&&$$     ",
            "     $&&&&&&&&$$                    $$&&&&&$      ",
            "     $&&&&&&&&$                     $&&&&&$$      ",
            "      $$$$$$$$$                     $$&&&&$       ",
            "                                     $$$$$        ",
    };

    String[] KIDHIT_IMAGE = {
            "                         $$$$$$$$                         ",
            "                        $$$$$$$$$$                        ",
            "                       $$$$$$$$$$$$                       ",
            "                      $$$$$$$$$$$$$$                      ",
            "                     $$$$$$$$$$$$$$$$                     ",
            "                     $$$$$$$$$$$$$$$$                     ",
            "                     $$$$$$$$$$$$$$$$                     ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                    $$$$$$$$$$$$$$$$$$                    ",
            "                     $$$$$$$$$$$$$$$$                     ",
            "                      $$$$$$$$$$$$$$                      ",
            "                        $$$$$$$$$$                        ",
            "                        $$$$$$$$$$                        ",
            "                      $$$))))))))$$$                      ",
            "                      $'$))))))))$'$                      ",
            "                     $''$))))))))$'$                      ",
            "   $$$               $'$$)$$$$$$)$''$              $$$    ",
            " $$$%$$$$$$$$$$$$$$$$''$)))))))))$$'$$$$$$$$$$$$$$$$%$$$$ ",
            "$$%%%%%%%%%%%%%%$'''''$)))))))))))$'''''$%%%%%%%%%%%%%%%$$",
            "$$%%%%%%%%%%%%%%$'''''$)))))))))))$$''''$%%%%%%%%%%%%%%%$$",
            " $$%%%%%%%%%%%%%$''''$$))))))))))))$''''$%%%%%%%%%%%%%%$$ ",
            "   $$$$$$$$$$$$$$$$$$$)))$$$$$$$$)))$$$$$$$$$$$$$$$$$$$   ",
            "                    $))))$))))))$))))$                    ",
            "                    $))))$))))))$))))$                    ",
            "  $$$               $$$$)$))))))$)$$$$               $$$  ",
            " $$&$                $)$$$))))))$$$)$                $&$$ ",
            " $&&$$               $))))$$$$$$))))$               $$&&$ ",
            " $&&&$               $))))))))))))))$               $&&&$ ",
            " $&&&$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$&&&$ ",
            " $&&&$(((((((((((((((($)))$$$$$$)))$(((((((((((((((($&&&$ ",
            " $&&&$(((((((((((((((($))))))))))))$(((((((((((((((($&&&$ ",
            " $&&&$(((((((((((((((($$$$$$$$$$$$$$(((((((((((((((($&&&$ ",
            " $&&&$(((((((((((((((((((((((((((((((((((((((((((((($&&&$ ",
            " $&&&$(((((((((((((((((((((((((((((((((((((((((((((($&&&$ ",
            " $&&&$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$&&&$ ",
            "  $$$                                                $$$  ",
    };

    String[] ARROWDOWN_IMAGE = {
            "$$$$$$$$$$$$$$$$",
            "$$GGGGGGGGGGGG$$",
            " $GGGGGGGGGGGG$ ",
            " $$GGGGGGGGGG$$ ",
            "  $$GGGGGGGG$$  ",
            "   $GGGGGGGG$   ",
            "   $$GGGGGG$$   ",
            "    $GGGGGG$    ",
            "    $$GGGG$$    ",
            "     $GGGG$     ",
            "     $$GG$$     ",
            "      $GG$      ",
            "      $$$$      ",
            "       $$       ",
            "       $$       ",
    };

    @BeforeEach
    void init() {
        kid = Mockito.mock(Kid.class);
        position = Mockito.mock(Position.class);
        Mockito.when(position.getX()).thenReturn(10);
        Mockito.when(position.getY()).thenReturn(20);
        Mockito.when(kid.getPosition()).thenReturn(position);
        gui = Mockito.mock(GUI.class);
        kidView = Mockito.spy(KidView.class);
    }

    @Test
    void drawStand() {
        Mockito.when(kid.getWalkingState()).thenReturn(false);

        kidView.draw(kid, gui);

        Mockito.verify(gui).drawImage(Mockito.any(Position.class), Mockito.eq(KIDSTAND_IMAGE));
    }

    @Test
    void drawWalkFirstHalf() {
        Mockito.when(kid.getWalkingState()).thenReturn(true);
        Mockito.when(kid.isFirstHalfOfMovement()).thenReturn(true);

        kidView.draw(kid, gui);

        Mockito.verify(gui).drawImage(Mockito.any(Position.class), Mockito.eq(KIDWALK_IMAGE));
    }

    @Test
    void drawWalkSecondHalf() {
        Mockito.when(kid.getWalkingState()).thenReturn(true);
        Mockito.when(kid.isFirstHalfOfMovement()).thenReturn(false);

        kidView.draw(kid, gui);

        Mockito.verify(gui).drawImage(Mockito.any(Position.class), Mockito.eq(KIDSTAND_IMAGE));
    }

    @Test
    void drawHit() {
        Mockito.when(kid.getIsHit()).thenReturn(true);

        kidView.draw(kid, gui);

        Mockito.verify(gui).drawImage(Mockito.any(Position.class), Mockito.eq(KIDHIT_IMAGE));
    }

    @Test
    void drawSelected() {
        Mockito.when(kid.isSelected()).thenReturn(true);

        kidView.draw(kid, gui);

        Mockito.verify(gui).drawImage(Mockito.any(Position.class), Mockito.eq(ARROWDOWN_IMAGE));
    }

}
