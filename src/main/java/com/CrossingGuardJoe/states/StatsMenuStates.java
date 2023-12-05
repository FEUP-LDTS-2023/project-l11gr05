package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.StatsMenuController;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.StatsMenuViewer;

public class StatsMenuStates extends State<StatsMenu> {
    public StatsMenuStates(StatsMenu model) {
        super(model);
    }

    @Override
    public Controller<StatsMenu> getController() {
        return new StatsMenuController(getModel());
    }

    @Override
    public Viewer<StatsMenu> getViewer() {
        return new StatsMenuViewer(getModel());
    }
}
