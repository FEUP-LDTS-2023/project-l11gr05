package com.CrossingGuardJoe.model.game.elements.JoeCommand;

import com.CrossingGuardJoe.model.game.elements.Joe;

public class JoeWalkToRightCommand implements CommandJoe{
    private final Joe joe;

    public JoeWalkToRightCommand(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.startWalkingToRight();
    }

}
