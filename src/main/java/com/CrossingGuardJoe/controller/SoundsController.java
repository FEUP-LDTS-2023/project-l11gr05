package com.CrossingGuardJoe.controller;

import java.util.Objects;
import java.util.Random;

import static com.CrossingGuardJoe.controller.Sounds.SFX;

public class SoundsController {
    private Sounds select, enter, customizeBgm, instructionsBgm, flipPage;
    private Sounds gameBgm, levelUp;
    private Sounds joePass1, joePass2, joeStop;
    private Sounds kidWalk1, kidStop1, kidStop2, kidHit;
    private Sounds carBreak;

    private static SoundsController soundsController;

    private SoundsController() {
        select = new Sounds("sounds/menu/SELECT.wav");
        enter = new Sounds("sounds/menu/ENTER.wav");
        customizeBgm = new Sounds("sounds/menu/CUSTOMIZEBGM.wav");
        instructionsBgm = new Sounds("sounds/menu/INSTRUCTIONSBGM.wav");
        flipPage = new Sounds("sounds/menu/FLIPPAGE.wav");

        gameBgm = new Sounds("sounds/GAMEBGM.wav");
        levelUp = new Sounds("sounds/LEVELUP.wav");

        joePass1 = new Sounds("sounds/joe/JOEPASS1.wav");
        joePass2 = new Sounds("sounds/joe/JOEPASS2.wav");
        joeStop = new Sounds("sounds/joe/JOESTOP.wav");

        kidWalk1 = new Sounds("sounds/kid/KIDWALK1.wav");
        kidStop1 = new Sounds("sounds/kid/KIDSTOP1.wav");
        kidStop2 = new Sounds("sounds/kid/KIDSTOP2.wav");
        kidHit = new Sounds("sounds/kid/KIDHIT.wav");

        carBreak = new Sounds("sounds/car/CARBREAK.wav");
    }

    public static SoundsController getInstance() {
        if (soundsController == null) {
            soundsController = new SoundsController();
        }
        return soundsController;
    }

    public void play(SFX sfx) {
        switch (sfx) {
            case SELECT -> select.play();
            case ENTER -> enter.play();
            case FLIPPAGE -> flipPage.play();
            case CUSTOMIZEBGM -> customizeBgm.loop(1f);
            case INSTRUCTIONSBGM -> instructionsBgm.loop(0.2f);
            case GAMEBGM -> gameBgm.loop(0.2f);
            case LEVELUP -> levelUp.play();
            case JOEPASS1 -> joePass1.play();
            case JOEPASS2 -> joePass2.play();
            case JOESTOP -> joeStop.play();
            case KIDWALK1 -> kidWalk1.play();
            case KIDSTOP1 -> kidStop1.play();
            case KIDSTOP2 -> kidStop2.play();
            case KIDHIT -> kidHit.play();
            case CARBREAK -> carBreak.play();
        }
    }

    public void pause(SFX sfx) {
        if (Objects.requireNonNull(sfx) == SFX.GAMEBGM) {
            gameBgm.pause();
        }
    }

    public void stop(SFX sfx) {
        switch(sfx) {
            case GAMEBGM -> gameBgm.stop();
            case CUSTOMIZEBGM -> customizeBgm.stop();
            case INSTRUCTIONSBGM -> instructionsBgm.stop();
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
