package com.aor.CrossingGuardJoe.model.game.elements;

import java.util.StringTokenizer;

public class JoeWalkToLeftCommand implements CommandJoe{
    private final Joe joe;
    private final String name = "WalkLeft";

    public JoeWalkToLeftCommand(Joe joe) {
        this.joe = joe;
    }
    @Override
    public void execute() {
        joe.startWalkingToLeft();
    }

    @Override
    public String getCommandName() {
        return name;
    }
}
