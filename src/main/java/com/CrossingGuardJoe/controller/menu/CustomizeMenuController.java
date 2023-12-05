package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.controller.Sounds;
import com.CrossingGuardJoe.controller.SoundsController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;

import java.io.IOException;

public class CustomizeMenuController extends Controller<CustomizeMenu> {
    private char oldColor;
    public CustomizeMenuController(CustomizeMenu model) {
        super(model);
        SoundsController.getInstance().play(Sounds.SFX.CUSTOMIZEBGM);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (!getModel().isColorPaletteSelected()) {
            switch (action) {
                case LEFT:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().navigateLeft();
                    break;
                case RIGHT:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().navigateRight();
                    break;
                case UP:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().navigateUp();
                    break;
                case DOWN:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().navigateDown();
                    break;
                case ESC:
                    SoundsController.getInstance().stop(Sounds.SFX.CUSTOMIZEBGM);
                    game.popState();
                    SoundsController.getInstance().play(Sounds.SFX.MENUBGM);
                    break;
                case SELECT:
                    SoundsController.getInstance().play(Sounds.SFX.ENTER);
                    oldColor = getModel().getSelectedColorChar();
                    getModel().setColorPaletteSelected(true);
                    break;
            }
        }
        else {
            switch (action) {
                case LEFT:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().getColorPaletteMenu().navigateLeft();
                    break;
                case RIGHT:
                    SoundsController.getInstance().play(Sounds.SFX.SELECT);
                    getModel().getColorPaletteMenu().navigateRight();
                    break;
                case ESC:
                    getModel().setColorPaletteSelected(false);
                    break;
                case SELECT:
                    SoundsController.getInstance().play(Sounds.SFX.ENTER);
                    char newColor = getModel().getColorPaletteMenu().getColorPalette().get(getModel().getColorPaletteMenu().getSelectedColorIndex()).getCharacter();
                    getModel().setColorChange(oldColor, newColor);
                    getModel().setColorPaletteSelected(false);
                    break;
            }
        }
    }
}
