package com.CrossingGuardJoe.model.game.elements.JoeCommand;

import com.CrossingGuardJoe.model.game.elements.Joe;

public class JoeWalkToLeftCommand implements CommandJoe{
    private final Joe joe;

    public JoeWalkToLeftCommand(Joe joe) {
        this.joe = joe;
    }
    @Override
    public void execute() {
        joe.startWalkingToLeft();
    }

}
