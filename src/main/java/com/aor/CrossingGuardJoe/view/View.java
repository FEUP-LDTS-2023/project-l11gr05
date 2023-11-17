package com.aor.CrossingGuardJoe.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class View {
    public TextGraphics viewer;

    public TextGraphics getViewer() {
        return viewer;
    }

    public void setViewer(TextGraphics viewer) {
        this.viewer = viewer;
    }

}


