package com.CrossingGuardJoe.states.menu;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.menu.GameOverMenuController;
import com.CrossingGuardJoe.model.menu.GameOverMenu;
import com.CrossingGuardJoe.model.menu.PauseMenu;
import com.CrossingGuardJoe.states.State;
import com.CrossingGuardJoe.viewer.Viewer;
import com.CrossingGuardJoe.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOverMenu> {
    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    public Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }

    @Override
    public Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }
}
