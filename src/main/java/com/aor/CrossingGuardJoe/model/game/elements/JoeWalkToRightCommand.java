package com.aor.CrossingGuardJoe.model.game.elements;

public class JoeWalkToRightCommand implements CommandJoe{
    private final Joe joe;
    private final String name = "WalkRight";

    public JoeWalkToRightCommand(Joe joe) {
        this.joe = joe;
    }
    @Override
    public void execute() {
        joe.startWalkingToRight();
    }

    @Override
    public String getCommandName() {
        return name;
    }
}
