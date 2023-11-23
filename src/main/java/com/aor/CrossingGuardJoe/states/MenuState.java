package com.aor.CrossingGuardJoe.states;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.viewer.Viewer;

public class MenuState extends State<Menu>{
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public Controller<Menu> getController() {
        return null;
    }

    @Override
    public Viewer<Menu> getViewer() {
        return null;
    }
}
