package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.game.Sounds;
import com.CrossingGuardJoe.controller.game.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.RoadBuilder;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.states.CustomizeMenuState;
import com.CrossingGuardJoe.states.GameState;
import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.states.InstructionsMenuState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().navigateUp();
                SoundsController.getInstance().play(Sounds.SFX.SELECT);
                break;
            case DOWN:
                getModel().navigateDown();
                SoundsController.getInstance().play(Sounds.SFX.SELECT);
                break;
            case SELECT:
                SoundsController.getInstance().play(Sounds.SFX.ENTER);
                if (getModel().isSelectedStartGame()) {
                    game.setState(new GameState(new RoadBuilder().createRoad()));
                    SoundsController.getInstance().play(Sounds.SFX.BGM);
                }
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsMenuState(new InstructionsMenu()));
                if (getModel().isSelectedCustomize()) game.setState(new CustomizeMenuState(new CustomizeMenu()));
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                    System.exit(0);
                }
        }

    }
}
