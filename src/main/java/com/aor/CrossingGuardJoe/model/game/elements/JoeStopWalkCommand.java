package com.aor.CrossingGuardJoe.model.game.elements;

public class JoeStopWalkCommand implements CommandJoe{
    private final Joe joe;
    private final String name = "StopWalk";

    public JoeStopWalkCommand(Joe joe) {
        this.joe = joe;
    }
    @Override
    public void execute() {
        joe.stopWalking();
    }

    @Override
    public String getCommandName() {
        return name;
    }
}
