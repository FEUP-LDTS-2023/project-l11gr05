package com.aor.CrossingGuardJoe.view.game;

import com.aor.CrossingGuardJoe.GUI;
import com.aor.CrossingGuardJoe.model.game.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface ElementViewer<T extends Element> {

    void draw(T element, GUI gui);

}
