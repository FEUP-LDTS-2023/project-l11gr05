package com.aor.CrossingGuardJoe.viewer.game.elements;

import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.elements.Element;

public abstract class ElementViewer<T extends Element> {

    public abstract void draw(T element, GUI gui);

}
