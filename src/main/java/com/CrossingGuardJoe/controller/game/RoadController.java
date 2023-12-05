package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.controller.game.elements.KidController;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.states.PauseMenuState;

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
            SoundsController.getInstance().stop(Sounds.SFX.BGM);
            game.setState(new PauseMenuState(new PauseMenu(getModel())));
        }
        if (getModel().getJoe().getHearts() == 0) {
            System.out.println("GAME OVER");

            game.popState();
        }
        if (getModel().isGameEnded()) {
            System.out.println("YOU COMPLETE");
            game.popState();
        }
    }
}
