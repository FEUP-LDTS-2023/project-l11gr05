package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.model.menu.StatsMenu;
import com.CrossingGuardJoe.states.menu.StatsMenuStates;

import java.io.IOException;

public class GameOverMenuController extends Controller<GameOverMenu> {
    public GameOverMenuController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                SoundsController.getInstance().play(Sounds.SFX.SELECT);
                getModel().navigateUp();
                break;
            case DOWN:
                SoundsController.getInstance().play(Sounds.SFX.SELECT);
                getModel().navigateDown();
                break;
            case SELECT:
                SoundsController.getInstance().play(Sounds.SFX.ENTER);
                if (getModel().isSelectedStats()) {
                    game.setState(new StatsMenuStates(new StatsMenu(
                                    getModel().getCurrentGame().getJoe().getScore(),
                                    getModel().getCurrentGame().getCurrentLevel(),
                                    game.getHighestScore(),
                                    game.getHighestLevel()
                                    )
                            )
                    );
                }
                if (getModel().isSelectedExit()) {
                    if (getModel().isWin()) {
                        SoundsController.getInstance().stop(Sounds.SFX.VICTORYBGM);
                    }
                    game.popState();
                    SoundsController.getInstance().play(Sounds.SFX.MENUBGM);
                }
        }
    }
}
