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

    Kid kidMock;
    GUI guiMock;
    Position positionMock;
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
        kidMock = Mockito.mock(Kid.class);
        positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(10);
        Mockito.when(positionMock.getY()).thenReturn(20);
        Mockito.when(kidMock.getPosition()).thenReturn(positionMock);
        guiMock = Mockito.mock(GUI.class);
        kidView = Mockito.spy(KidView.class);
    }

    @Test
    void drawStand() {
        Mockito.when(kidMock.getWalkingState()).thenReturn(false);

        kidView.draw(kidMock, guiMock);

        Mockito.verify(guiMock).drawImage(Mockito.any(Position.class), Mockito.eq(KIDSTAND_IMAGE));
    }

    @Test
    void drawWalkFirstHalf() {
        Mockito.when(kidMock.getWalkingState()).thenReturn(true);
        Mockito.when(kidMock.isFirstHalfOfMovement()).thenReturn(true);

        kidView.draw(kidMock, guiMock);

        Mockito.verify(guiMock).drawImage(Mockito.any(Position.class), Mockito.eq(KIDWALK_IMAGE));
    }

    @Test
    void drawWalkSecondHalf() {
        Mockito.when(kidMock.getWalkingState()).thenReturn(true);
        Mockito.when(kidMock.isFirstHalfOfMovement()).thenReturn(false);

        kidView.draw(kidMock, guiMock);

        Mockito.verify(guiMock).drawImage(Mockito.any(Position.class), Mockito.eq(KIDSTAND_IMAGE));
    }

    @Test
    void drawHit() {
        Mockito.when(kidMock.getIsHit()).thenReturn(true);

        kidView.draw(kidMock, guiMock);

        Mockito.verify(guiMock).drawImage(Mockito.any(Position.class), Mockito.eq(KIDHIT_IMAGE));
    }

    @Test
    void drawSelected() {
        Mockito.when(kidMock.isSelected()).thenReturn(true);

        kidView.draw(kidMock, guiMock);

        Mockito.verify(guiMock).drawImage(Mockito.any(Position.class), Mockito.eq(ARROWDOWN_IMAGE));
    }

}
