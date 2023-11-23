package com.aor.CrossingGuardJoe.states;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.viewer.Viewer;

public class MenuState extends State<Menu>{
    @Override
    public Controller<Menu> getController() {
        return null;
    }

    @Override
    public Viewer<Menu> getViewer() {
        return null;
    }
}
