package com.CrossingGuardJoe.states.menu;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.CustomizeMenuController;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.states.State;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.CustomizeMenuViewer;

public class CustomizeMenuState extends State<CustomizeMenu> {
    public CustomizeMenuState(CustomizeMenu model) {
        super(model);
    }

    @Override
    public Controller<CustomizeMenu> getController() {
        return new CustomizeMenuController(getModel());
    }

    @Override
    public Viewer<CustomizeMenu> getViewer() {
        return new CustomizeMenuViewer(getModel());
    }
}
