package com.aor.CrossingGuardJoe.model.game.elements;

public class JoeRaisingStopSign implements CommandJoe{
    private final Joe joe;
    private final String name = "StopSign";

    public JoeRaisingStopSign(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.startRaisingStopSign();
    }

    @Override
    public String getCommandName() {
        return name;
    }
}
