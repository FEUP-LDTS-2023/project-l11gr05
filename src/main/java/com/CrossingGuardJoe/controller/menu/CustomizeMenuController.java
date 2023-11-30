package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;

import java.io.IOException;

public class CustomizeMenuController extends Controller<CustomizeMenu> {
    public CustomizeMenuController(CustomizeMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
