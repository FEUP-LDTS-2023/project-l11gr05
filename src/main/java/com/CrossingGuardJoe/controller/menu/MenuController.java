package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.RoadBuilder;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.GameState;
import com.CrossingGuardJoe.Game;

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
        game.setState(new GameState(new RoadBuilder().createRoad()));
    }
}
