package com.CrossingGuardJoe.model.commands.JoeCommand;

import com.CrossingGuardJoe.model.commands.Command;
import com.CrossingGuardJoe.model.game.elements.Joe;

public class JoeWalkToRightCommand implements Command {
    private final Joe joe;

    public JoeWalkToRightCommand(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.startWalkingToRight();
    }

}
