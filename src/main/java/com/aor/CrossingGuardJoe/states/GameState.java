package com.aor.CrossingGuardJoe.states;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.controller.game.RoadController;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.viewer.Viewer;
import com.aor.CrossingGuardJoe.viewer.game.GameViewer;

public class GameState extends State<Road>{
    public GameState(Road road) { super(road);}

    @Override
    public Controller getController() {
        return new RoadController(getModel());
    }

    @Override
    public Viewer getViewer() {
        return new GameViewer(getModel());
    }
}
