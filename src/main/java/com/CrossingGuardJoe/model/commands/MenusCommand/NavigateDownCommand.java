package com.CrossingGuardJoe.model.commands.MenusCommand;

import com.CrossingGuardJoe.model.commands.Command;
import com.CrossingGuardJoe.model.menu.CustomizeMenu;
import com.CrossingGuardJoe.model.menu.Menu;

public class NavigateDownCommand implements Command {
    private final Object menu;

    public NavigateDownCommand(Object menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        if (menu instanceof Menu actualMenu) {
            actualMenu.nextOption();
        } else if (menu instanceof CustomizeMenu customizeMenu) {
            customizeMenu.navigateDown();
        } else {
            throw new IllegalArgumentException("Invalid menu type");
        }
    }
}
