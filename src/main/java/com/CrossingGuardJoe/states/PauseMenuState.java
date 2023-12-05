package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.PauseMenuController;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.PauseMenuViewer;

public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    public Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel());
    }

    @Override
    public Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }
}
