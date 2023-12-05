package com.CrossingGuardJoe.controller;

import com.CrossingGuardJoe.model.Position;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.InputStream;

public class Sounds {
    private final Clip sound;

    public enum SFX {
        JOEPASS1, JOEPASS2, JOESTOP, KIDWALK1, KIDSTOP1, KIDSTOP2, KIDHIT, CARBREAK, ENTER, SELECT, GAMEBGM, LEVELUP, CUSTOMIZEBGM, INSTRUCTIONSBGM,
        FLIPPAGE;
    }

    public Sounds(String sound) {
        this.sound = loadSound(sound);
    }

    private Clip loadSound(String sound) {
        try {
            InputStream audioInputStream = getClass().getClassLoader().getResourceAsStream(sound);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioInputStream);
            clip.open(ais);
            setVolume(clip, 0.5f);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void play() {
        if (!sound.isRunning()) {
            sound.setFramePosition(0);
            sound.start();
        }
    }

    public void pause() {
        sound.stop();
    }

    public void stop() {
        sound.setFramePosition(0);
        sound.stop();
    }

    public void loop(float volume) {
        setVolume(sound, volume);
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void setVolume(Clip clip, float volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }
}
