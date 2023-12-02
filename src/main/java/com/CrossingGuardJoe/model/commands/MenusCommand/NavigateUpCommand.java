package com.CrossingGuardJoe.model.commands.MenusCommand;

import com.CrossingGuardJoe.model.commands.Command;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Menu;

public class NavigateUpCommand implements Command {
    private final Object menu;

    public NavigateUpCommand(Object menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        if (menu instanceof Menu actualMenu) {
            actualMenu.previousOption();
        } else if (menu instanceof CustomizeMenu customizeMenu) {
            customizeMenu.navigateUp();
        } else {
            throw new IllegalArgumentException("Invalid menu type");
        }
    }
}
