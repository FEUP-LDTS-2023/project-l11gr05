package com.aor.CrossingGuardJoe.viewer;

import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.Element;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.viewer.Elements.ElementViewer;
import com.aor.CrossingGuardJoe.viewer.Elements.JoeView;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Road> {
    public GameViewer(Road road) {
        super(road);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        drawElement(gui, getModel().getJoe(), new JoeView());
        //drawElements(gui, getModel().getKids(), new KidView());
        //drawElements(gui, getModel().getCars(), new CarView());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }


}
