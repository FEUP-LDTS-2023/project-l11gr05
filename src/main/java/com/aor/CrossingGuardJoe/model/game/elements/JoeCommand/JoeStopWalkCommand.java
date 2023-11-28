package com.aor.CrossingGuardJoe.model.game.elements.JoeCommand;

import com.aor.CrossingGuardJoe.model.game.elements.Joe;

public class JoeStopWalkCommand implements CommandJoe{
    private final Joe joe;

    public JoeStopWalkCommand(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.stopWalking();
    }

}
