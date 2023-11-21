package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.model.game.Kid;
import com.aor.CrossingGuardJoe.view.drawer.Draw;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class KidView extends Draw {
    private Kid kid;
    private int frameCounter = 0;
    private final int FRAME_DURATION = 10;
    private final String[] kidStandImage = new String[]{
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

    private final String[] kidWalkImage = new String[] {
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

    public KidView(TextGraphics graphics) {
        super(graphics);
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    public void drawKidStand() {
        drawImage(kid.getPosition().getX(), kid.getPosition().getY(), kidStandImage);
    }

    private void drawKidWalk() {
        drawImage(kid.getPosition().getX(), kid.getPosition().getY(), kidWalkImage);
    }

    public void draw() throws IOException {
        frameCounter++;
        if (frameCounter >= FRAME_DURATION) {
            frameCounter = 0;
            kid.setWalking(!kid.getIsWalking());
        }
        if (kid.getIsWalking()) {
            drawKidWalk();
        } else {
            drawKidStand();
        }
    }
}
