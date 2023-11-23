package com.aor.CrossingGuardJoe.states;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.viewer.Viewer;

public class GameState extends State<Road>{
    public GameState(Road road) { super(road);}

    @Override
    public Controller getController() {
        return null;
        //return new GameViewer(getModel());
    }

    @Override
    public Viewer getViewer() {
        return null;
        //return new RoadController(getModel());
    }
}
