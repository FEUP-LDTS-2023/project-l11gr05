package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu model) {
        super(model);
        SoundsController.getInstance().play(Sounds.SFX.INSTRUCTIONSBGM);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case RIGHT:
                getModel().navigateRight();
                break;
            case LEFT:
                getModel().navigateLeft();
                break;
            case ESC:
                SoundsController.getInstance().stop(Sounds.SFX.INSTRUCTIONSBGM);
                game.popState();
                SoundsController.getInstance().play(Sounds.SFX.MENUBGM);
                break;
        }
    }
}
