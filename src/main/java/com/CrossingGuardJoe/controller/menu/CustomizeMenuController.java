package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;

import java.io.IOException;

public class CustomizeMenuController extends Controller<CustomizeMenu> {
    private char oldColor;
    public CustomizeMenuController(CustomizeMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (!getModel().isColorPaletteSelected()) {
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
                    oldColor = getModel().getSelectedColorChar();
                    getModel().setColorPaletteSelected(true);
                    break;
            }
        }
        else {
            switch (action) {
                case LEFT:
                    getModel().getColorPaletteMenu().navigateLeft();
                    break;
                case RIGHT:
                    getModel().getColorPaletteMenu().navigateRight();
                    break;
                case ESC:
                    getModel().setColorPaletteSelected(false);
                    break;
                case SELECT:
                    char newColor = getModel().getColorPaletteMenu().getColorPalette().get(getModel().getColorPaletteMenu().getSelectedColorIndex()).getCharacter();
                    getModel().setColorChange(oldColor, newColor);
                    getModel().setColorPaletteSelected(false);
                    break;
            }
        }
    }
}
