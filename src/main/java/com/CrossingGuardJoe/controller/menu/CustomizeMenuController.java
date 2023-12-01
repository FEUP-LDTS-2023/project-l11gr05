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
                if (getModel().isSelectedJoeCustomize()) {
                    // Perform action for Joe customization
                    performJoeCustomization();
                }
                if (getModel().isSelectedCarsCustomize()) {
                    // Perform action for Cars customization
                    performCarsCustomization();
                }
                if (getModel().isSelectedKidsCustomize()) {
                    // Perform action for Kids customization
                    performKidsCustomization();
                }
                break;


        }
    }

    // Customization methods for each selected option
    private void performJoeCustomization() {
        // Your logic for Joe customization
        // Example:
        System.out.println("Joe selected for customization");
    }

    private void performCarsCustomization() {
        // Your logic for Cars customization
        // Example:
        System.out.println("Cars selected for customization");
    }

    private void performKidsCustomization() {
        // Your logic for Kids customization
        // Example:
        System.out.println("Kids selected for customization");
    }

}
