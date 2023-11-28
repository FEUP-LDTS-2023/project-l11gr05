package com.aor.CrossingGuardJoe.model.game.elements;

public class JoeRaisingPassSign implements CommandJoe{
    private final Joe joe;
    private final String name = "PassSign";

    public JoeRaisingPassSign(Joe joe) {
        this.joe = joe;
    }
    @Override
    public void execute() {
        joe.startRaisingPassSign();
    }

    @Override
    public String getCommandName() {
        return name;
    }
}
