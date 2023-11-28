package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.game.RoadController;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.game.GameViewer;

public class GameState extends State<Road>{
    public GameState(Road road) { super(road); }

    @Override
    public Controller<Road> getController() {
        return new RoadController(getModel());
    }

    @Override
    public Viewer<Road> getViewer() {
        return new GameViewer(getModel());
    }
}
