package com.aor.CrossingGuardJoe.viewer.game;

import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.elements.Element;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.viewer.Viewer;
import com.aor.CrossingGuardJoe.viewer.game.Elements.CarView;
import com.aor.CrossingGuardJoe.viewer.game.Elements.JoeView;
import com.aor.CrossingGuardJoe.viewer.game.Elements.ElementViewer;
import com.aor.CrossingGuardJoe.viewer.game.Elements.KidView;

import java.util.List;

public class GameViewer extends Viewer<Road> {
    public GameViewer(Road model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawRoadLines();
        drawElements(gui, getModel().getCars(), new CarView());
        drawElement(gui, getModel().getJoe(), new JoeView());
        drawElements(gui, getModel().getKids(), new KidView());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
