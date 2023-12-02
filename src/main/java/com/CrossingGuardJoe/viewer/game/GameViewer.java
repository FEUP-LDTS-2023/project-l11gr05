package com.CrossingGuardJoe.viewer.game;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.viewer.Text;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.model.game.elements.Element;
import com.CrossingGuardJoe.viewer.game.elements.CarView;
import com.CrossingGuardJoe.viewer.game.elements.ElementViewer;
import com.CrossingGuardJoe.viewer.game.elements.JoeView;
import com.CrossingGuardJoe.viewer.game.elements.KidView;
import com.CrossingGuardJoe.viewer.images.HUDImages;
import com.CrossingGuardJoe.viewer.images.RoadElementsImages;

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

        drawHUD(gui);
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
        int ROAD_START_Y = 38;

        //boards
        gui.setColorHexaCode("#C0BBB1");
        gui.fillRectangle(new Position(0, ROAD_START_Y),150, 500);
        gui.fillRectangle(new Position(850, ROAD_START_Y), 150, 500);

        //crossing line
        int iniX = 167;
        for (int i = 0; i < 834 - iniX - 15; i += 24) {
            gui.fillRectangle(new Position(iniX + i, 368), 16, 50);
        }

        //road middle lines
        gui.fillRectangle(new Position(326, ROAD_START_Y), 4, 340);
        gui.fillRectangle(new Position(500, ROAD_START_Y), 4, 340);
        gui.fillRectangle(new Position(674, ROAD_START_Y), 4, 340);

        //details
        gui.setColorHexaCode("#3D3638");
        gui.fillRectangle(new Position(150, ROAD_START_Y), 2, 500);
        gui.fillRectangle(new Position(154, ROAD_START_Y), 2, 500);
        gui.fillRectangle(new Position(848, ROAD_START_Y), 2, 500);
        gui.fillRectangle(new Position(844, ROAD_START_Y), 2, 500);

    }

    @Override
    public void drawRoadItems() {
        gui.drawImage(new Position(426, 258), RoadElementsImages.SIGNAL);
        gui.drawImage(new Position(55, 258), RoadElementsImages.SIGNAL);
    }

    private void drawHUD(GUI gui) {
        gui.drawImage(new Position(0, 0), HUDImages.GAME_HUD);

        gui.drawImage(new Position(165, 10), new Text().getNumberImage(getModel().getJoe().getScore()));
        gui.drawImageCustomColor(new Position(164, 9), new Text().getNumberImage(getModel().getJoe().getScore()), "#FFFFFF");

        int heartIniX = 246;
        for (int i = 0; i < getModel().getJoe().getHearts(); i++) {
            gui.drawImage(new Position(heartIniX, 4), HUDImages.MINI_KID);
            heartIniX += 25;
        }
    }

}
