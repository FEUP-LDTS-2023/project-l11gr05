package com.aor.CrossingGuardJoe.view;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class View {
    private TextGraphics graphics;

    public abstract void draw() throws IOException;

}
