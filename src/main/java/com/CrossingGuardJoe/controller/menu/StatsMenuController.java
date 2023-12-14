package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.StatsMenu;

import java.io.IOException;

public class StatsMenuController extends Controller<StatsMenu> {
    public StatsMenuController(StatsMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.ESC) {
            game.popState();
        }
    }
}
