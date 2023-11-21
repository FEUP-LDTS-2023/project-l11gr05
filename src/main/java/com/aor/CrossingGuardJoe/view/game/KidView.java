package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.GUI;
import com.aor.CrossingGuardJoe.model.game.Element;
import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.drawer.Draw;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.text.View;
import java.io.IOException;

public class KidView implements ElementViewer {
    private String[] kidStandImage = new String[]{
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
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
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  "
    };

    private String[] kidWalkImage = new String[] {
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
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
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  ",
            "                                                  "

    };

    private void drawKidStand(Kid kid, TextGraphics graphics) {
        this.draw = new Draw(graphics);
        this.kid = kid;
        draw.drawImage(kid.getPosition().getX(), kid.getPosition().getY(), kidStandImage);
        isWalking = false;
    }

    private void drawKidWalk(Kid kid, TextGraphics graphics) {
        this.draw = new Draw(graphics);
        this.kid = kid;
        draw.drawImage(kid.getPosition().getX(), kid.getPosition().getY(), kidWalkImage);
        isWalking = true;
    }

    @Override
    public void draw() throws IOException {
        /*frameCounter++;

        if (frameCounter >= FRAME_DURATION) {
            frameCounter = 0;
            isWalking = !isWalking; // Alterna entre parado e movimento a cada FRAME_DURATION
        }

        if (isWalking) {
            drawKidWalk(kid, graphics);
        } else {
            drawKidStand(kid, graphics);
        }*/
    }

    public KidView(TextGraphics graphics, Kid kid) {
        this.graphics = graphics;
        this.kid = kid;
        drawKidStand(kid, graphics);
        drawKidWalk(kid, graphics);
    }

    @Override
    public void draw(Element element, GUI gui) {

    }
}
