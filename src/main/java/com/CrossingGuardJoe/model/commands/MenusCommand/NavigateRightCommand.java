package com.CrossingGuardJoe.model.commands.MenusCommand;

import com.CrossingGuardJoe.model.commands.Command;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;

public class NavigateRightCommand implements Command {
    private final Object menu;

    public NavigateRightCommand(Object menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        if (menu instanceof CustomizeMenu customizeMenu) {
            customizeMenu.navigateRight();
        }
        else {
            throw new IllegalArgumentException("Invalid menu type");
        }
    }
}
