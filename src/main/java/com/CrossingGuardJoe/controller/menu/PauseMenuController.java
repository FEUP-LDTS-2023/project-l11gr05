package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.PauseMenu;

import java.io.IOException;

public class PauseMenuController extends Controller<PauseMenu> {
    public PauseMenuController(PauseMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().navigateUp();
                break;
            case DOWN:
                getModel().navigateDown();
                break;
            case ESC:
                game.popState();
                break;
            case SELECT:
                if (getModel().isSelectedResume()) game.popState();
                if (getModel().isSelectedStats()); //todo
                if (getModel().isSelectedExit()) {
                    game.popState();
                    game.popState();
                }
        }
    }
}
