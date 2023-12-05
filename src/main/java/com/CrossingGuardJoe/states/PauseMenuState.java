package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.viewer.Viewer;

public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    public Controller<PauseMenu> getController() {
        return new ;
    }

    @Override
    public Viewer<PauseMenu> getViewer() {
        return null;
    }
}
