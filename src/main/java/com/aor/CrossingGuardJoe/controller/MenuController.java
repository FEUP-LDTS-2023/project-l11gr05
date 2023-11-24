package com.aor.CrossingGuardJoe.controller;

import com.aor.CrossingGuardJoe.Game;
import com.aor.CrossingGuardJoe.gui.GUI;
import com.aor.CrossingGuardJoe.model.game.LoaderRoadBuilder;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.menu.Menu;
import com.aor.CrossingGuardJoe.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) { super(menu); }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        /*switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
            case SELECT:
                if (getModel().StartGame())
                    game.setState(new GameState(new LoaderRoadBuilder().createRoad()));
        }*/
        game.setState(new GameState(new LoaderRoadBuilder().createRoad()));
    }
}
