package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.controller.game.elements.KidController;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.states.menu.GameOverState;
import com.CrossingGuardJoe.states.menu.PauseMenuState;

import java.io.IOException;

public class RoadController extends GameController {
    private final JoeController joeController;
    private final KidController kidController;
    private final CarController carController;

    public RoadController(Road road) {
        super(road);

        this.joeController = new JoeController(road);
        this.kidController = new KidController(road);
        this.carController = new CarController(road);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        joeController.nextAction(game, action, time);
        kidController.nextAction(game, action, time);
        carController.nextAction(game, action, time);

        if (getModel().getJoe().getScore() > game.getHighestScore()) {
            game.setHighestScore(getModel().getJoe().getScore());
        }
        if (getModel().getCurrentLevel() > game.getHighestLevel()) {
            game.setHighestLevel(getModel().getCurrentLevel());
        }

        if (action == GUI.ACTION.ESC) {
            SoundsController.getInstance().pause(Sounds.SFX.GAMEBGM);
            getModel().getJoe().stopWalking();
            game.setState(new PauseMenuState(new PauseMenu(getModel())));
        }
        if (getModel().getJoe().getHearts() == 0) {
            SoundsController.getInstance().stop(Sounds.SFX.GAMEBGM);
            SoundsController.getInstance().stop(Sounds.SFX.CARBREAK);
            game.popState();
            game.setState(new GameOverState(new GameOverMenu(false, getModel())));
            SoundsController.getInstance().play(Sounds.SFX.GAMEOVER);
        }
        if (getModel().isGameEnded()) {
            SoundsController.getInstance().stop(Sounds.SFX.GAMEBGM);
            game.popState();
            game.setState(new GameOverState(new GameOverMenu(true, getModel())));
            SoundsController.getInstance().play(Sounds.SFX.VICTORYBGM);
        }
    }
}
