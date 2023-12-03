package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
