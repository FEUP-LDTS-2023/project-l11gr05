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

    private float defaultVolume = 0.5f;
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
            case SELECT -> select.play(defaultVolume);
            case ENTER -> enter.play(defaultVolume);
            case FLIPPAGE -> flipPage.play(defaultVolume);
            case CUSTOMIZEBGM -> customizeBgm.loop(1f);
            case INSTRUCTIONSBGM -> instructionsBgm.loop(0.2f);
            case GAMEBGM -> gameBgm.loop(0.15f);
            case LEVELUP -> levelUp.play(1f);
            case JOEPASS1 -> joePass1.play(defaultVolume);
            case JOEPASS2 -> joePass2.play(defaultVolume);
            case JOESTOP -> joeStop.play(defaultVolume);
            case KIDWALK1 -> kidWalk1.play(defaultVolume);
            case KIDSTOP1 -> kidStop1.play(defaultVolume);
            case KIDSTOP2 -> kidStop2.play(defaultVolume);
            case KIDHIT -> kidHit.play(defaultVolume);
            case CARBREAK -> carBreak.play(defaultVolume);
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
