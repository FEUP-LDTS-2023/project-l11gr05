package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.GUI;
import com.aor.CrossingGuardJoe.model.game.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class ElementViewer {
    private TextGraphics graphics;

    public abstract void draw() throws IOException;


}
