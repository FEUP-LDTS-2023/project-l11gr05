package com.CrossingGuardJoe.controller.menu;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.commands.Command;
import com.CrossingGuardJoe.model.commands.MenusCommand.NavigateDownCommand;
import com.CrossingGuardJoe.model.commands.MenusCommand.NavigateLeftCommand;
import com.CrossingGuardJoe.model.commands.MenusCommand.NavigateRightCommand;
import com.CrossingGuardJoe.model.commands.MenusCommand.NavigateUpCommand;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;

import java.io.IOException;

public class CustomizeMenuController extends Controller<CustomizeMenu> {
    private Command command;
    private char oldColor;
    public CustomizeMenuController(CustomizeMenu model) {
        super(model);
    }

    @Override
    public void nextAction(Game game, GUI.ACTION action, long time) throws IOException {
        if (!getModel().isColorPaletteSelected()) {
            switch (action) {
                case LEFT:
                    this.command = new NavigateLeftCommand(this.getModel());
                    break;
                case RIGHT:
                    this.command = new NavigateRightCommand(this.getModel());
                    break;
                case UP:
                    this.command = new NavigateUpCommand(this.getModel());
                    break;
                case DOWN:
                    this.command = new NavigateDownCommand(this.getModel());
                    break;
                case ESC:
                    game.popState();
                    break;
                case SELECT:
                    oldColor = getModel().getSelectedColorChar();
                    getModel().setColorPaletteSelected(true);
                    break;
            }
            getModel().setAndExecuteCommand(this.command);
        }
        else {
            switch (action) {
                case LEFT:
                    this.command = new NavigateLeftCommand(this.getModel().getColorPalette());
                    break;
                case RIGHT:
                    this.command = new NavigateRightCommand(this.getModel().getColorPalette());
                    break;
                case ESC:
                    getModel().setColorPaletteSelected(false);
                    break;
                case SELECT:
                    char newColor = getModel().getColorPalette().getColorPalette().get(getModel().getColorPalette().getSelectedColorIndex()).getCharacter();
                    getModel().setColorChange(oldColor, newColor);
                    getModel().setColorPaletteSelected(false);
                    break;
            }
            getModel().getColorPalette().setAndExecuteCommand(this.command);
        }
        this.command = null;
    }
}
