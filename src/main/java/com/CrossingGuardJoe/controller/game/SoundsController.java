package com.CrossingGuardJoe.controller.game;

import java.util.Random;

import static com.CrossingGuardJoe.controller.game.Sounds.SFX;
import static com.CrossingGuardJoe.controller.game.Sounds.SFX.KIDWALK1;

public class SoundsController {
    private Sounds joePass1, joePass2;
    private Sounds kidWalk1, kidStop1, kidStop2, kidHit;
    private Sounds carBreak;
    private Sounds bgm, select, enter;

    private static SoundsController soundsController;

    private SoundsController() {
        joePass1 = new Sounds("sounds/joe/JOEPASS1.wav");
        joePass2 = new Sounds("sounds/joe/JOEPASS2.wav");

        kidWalk1 = new Sounds("sounds/kid/KIDWALK1.wav");
        kidStop1 = new Sounds("sounds/kid/KIDSTOP1.wav");
        kidStop2 = new Sounds("sounds/kid/KIDSTOP2.wav");
        kidHit = new Sounds("sounds/kid/KIDHIT.wav");

        carBreak = new Sounds("sounds/car/CARBREAK.wav");

        bgm = new Sounds("sounds/BGM.wav");
        select = new Sounds("sounds/menu/SELECT.wav");
        enter = new Sounds("sounds/menu/ENTER.wav");
    }

    public static SoundsController getInstance() {
        if (soundsController == null) {
            soundsController = new SoundsController();
        }
        return soundsController;
    }

    public void play(SFX sfx) {
        switch (sfx) {
            case JOEPASS1 -> joePass1.play();
            case JOEPASS2 -> joePass2.play();
            case KIDWALK1 -> kidWalk1.play();
            case KIDSTOP1 -> kidStop1.play();
            case KIDSTOP2 -> kidStop2.play();
            case KIDHIT -> kidHit.play();
            case CARBREAK -> carBreak.play();
            case BGM -> bgm.loop();
            case SELECT -> select.play();
            case ENTER -> enter.play();
        }
    }

    public void stop(SFX sfx) {
        switch(sfx) {
            case BGM -> bgm.stop();
        }
    }

    public static void playRandom(SFX sfx1, SFX sfx2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            getInstance().play(sfx1);
        } else {
            getInstance().play(sfx2);
        }
    }
}
