package com.CrossingGuardJoe.viewer.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Element;

public abstract class ElementViewer<T extends Element> {

    public abstract void draw(T element, GUI gui);

}
