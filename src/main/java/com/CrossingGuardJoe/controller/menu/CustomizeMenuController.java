package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Option;

import java.io.IOException;

public class CustomizeMenuController extends Controller<CustomizeMenu> {
    public CustomizeMenuController(CustomizeMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().navigateLeft();
                break;
            case RIGHT:
                getModel().navigateRight();
                break;
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
                // Perform action based on the selected option
                if (getModel().isSelectedJoe()) {}
                if (getModel().isSelectedKids()) {}
                if (getModel().isSelectedCars()) {}
                if (getModel().isSelectedBack()) {}


        }
    }

}
