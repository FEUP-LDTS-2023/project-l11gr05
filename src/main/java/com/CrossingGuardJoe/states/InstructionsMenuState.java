package com.CrossingGuardJoe.states;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.InstructionsMenuController;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<InstructionsMenu>{

    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    public Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }

    @Override
    public Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }
}
