package com.aor.CrossingGuardJoe.viewer.game.Elements;

import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.Position;
import com.aor.CrossingGuardJoe.model.game.elements.Element;
import com.aor.CrossingGuardJoe.viewer.Color;

public abstract class ElementViewer<T extends Element> {

    public abstract void draw(T element, GUI gui);

}
