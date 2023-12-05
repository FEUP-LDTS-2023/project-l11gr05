package com.CrossingGuardJoe.states.menu;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.MenuController;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.State;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    @Override
    public Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
}
