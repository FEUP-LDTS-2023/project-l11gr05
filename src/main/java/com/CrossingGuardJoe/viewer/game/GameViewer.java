package com.CrossingGuardJoe.viewer.game;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.model.game.elements.Element;
import com.CrossingGuardJoe.viewer.game.elements.CarView;
import com.CrossingGuardJoe.viewer.game.elements.ElementViewer;
import com.CrossingGuardJoe.viewer.game.elements.JoeView;
import com.CrossingGuardJoe.viewer.game.elements.KidView;

import java.util.ArrayList;
import java.util.List;

public class GameViewer extends Viewer<Road> implements RoadView{
    private GUI gui;
    public GameViewer(Road model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        this.gui = gui;
        drawRoad();

        List<Car> carsCopy;
        synchronized (getModel().getCars()) {
            carsCopy = new ArrayList<>(getModel().getCars());
        }
        drawElements(gui, carsCopy, new CarView());

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

    @Override
    public void drawRoad() {
        drawRoadLines();
        drawRoadItems();
    }

    @Override
    public void drawRoadLines() {
        //boards
        gui.setColorHexaCode("#C0BBB1");
        gui.fillRectangle(new Position(0, 0),150, 500);
        gui.fillRectangle(new Position(850, 0), 150, 500);

        //crossing line
        int iniX = 167;
        for (int i = 0; i < 834 - iniX - 15; i += 24) {
            gui.fillRectangle(new Position(iniX + i, 368), 16, 50);
        }

        //road middle lines
        gui.fillRectangle(new Position(326, 0), 4, 340);
        gui.fillRectangle(new Position(500, 0), 4, 340);
        gui.fillRectangle(new Position(674, 0), 4, 340);

        //details
        gui.setColorHexaCode("#3D3638");
        gui.fillRectangle(new Position(150, 0), 2, 500);
        gui.fillRectangle(new Position(154, 0), 2, 500);
        gui.fillRectangle(new Position(848, 0), 2, 500);
        gui.fillRectangle(new Position(844, 0), 2, 500);

    }

    @Override
    public void drawRoadItems() {
        gui.drawImage(new Position(426, 258), signalImage);
        gui.drawImage(new Position(55, 258), signalImage);
    }

    private final String[] signalImage = {
            "                 $$$$$                 ",
            "                $$<<<$$                ",
            "               $$<<<<<$$               ",
            "              $$<<<<<<<$$              ",
            "             $$<<<<<<<<<$$             ",
            "            $$<<<<<<<<<<<$$            ",
            "           $$<<<<<<<<<<<<<$$           ",
            "          $$<<<<<<<<<<<<<<<$$          ",
            "         $$<<<<<$$$$<<<<<<<<$$         ",
            "        $$<<<<<<$$$$<<<<<<<<<$$        ",
            "       $$<<<<<<<$$$$<<<<<<<<<<$$       ",
            "      $$<<<<<<<<$$$$<<<<<<<<<<<$$      ",
            "     $$<<<<<<<<<<<$$$$$<<<<<<<<<$$     ",
            "    $$<<<<<<<<<<<<$$$$$<<<<<<<<<<$$    ",
            "   $$<<<<<<<<<<<<<$$$<<$$<<<<<<<<<$$   ",
            "  $$<<<<<<<<<<$$$$$$$<<$$<<<<<<<<<<$$  ",
            " $$<<<<<<<<<<<$$$$$$$<<$$<<<<<<<<<<<$$ ",
            "$$<<<<<<<<<<<<<<<<$$$<<<<<<<<<<<<<<<<$$",
            "$<<<<<<<<<<<<<<<<<$$$<<<<<<<<<<<<<<<<<$",
            "$<<<<<<<<<<<<<<<<<$$$<<<<<<<<<<<<<<<<<$",
            "$$<<<<<<<<<<<<<<<<$$$<<<<<<<<<<<<<<<<$$",
            " $$<<<<<<<<<<<<<$$<<$$<<<<<<<<<<<<<<$$ ",
            "  $$<<<<<<<<<<<<$$<<$$<<<<<<<<<<<<<$$  ",
            "   $$<<<<<<<<<$$<<<<<<$<<<<<<<<<<<$$   ",
            "    $$<<<<<<<<$$<<<<<<<$$<<<<<<<<$$    ",
            "     $$<<<<<<<$$<<<<<<<$$<<<<<<<$$     ",
            "      $$<<<<<$$$<<<<<$$$$<<<<<<$$      ",
            "       $$<<<<$$$<<<<<$$$$<<<<<$$       ",
            "        $$<<<<<<<<<<<<<<<<<<<$$        ",
            "         $$<<<<<<<<<<<<<<<<<$$         ",
            "          $$<<<<<<<<<<<<<<<$$          ",
            "           $$<<<<<<<<<<<<<$$           ",
            "            $$<<<<<<<<<<<$$            ",
            "             $$<<<<<<<<<$$             ",
            "              $$<<<<<<<$$              ",
            "               $$<<<<<$$               ",
            "                $$$$$$$                ",
            "                $$$$$$$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "         $$$$$$$$$$$$$$$$$$$$$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $»»»»»»»»»»»»»»»»»»»$         ",
            "         $$$$$$$$$$$$$$$$$$$$$         ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $AAAAA$                ",
            "                $$$$$$$                ",
            "                 $$$$$                 ",

    };
}
