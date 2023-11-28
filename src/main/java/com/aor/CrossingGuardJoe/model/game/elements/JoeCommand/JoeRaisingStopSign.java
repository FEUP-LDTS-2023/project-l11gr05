package com.aor.CrossingGuardJoe.model.game.elements.JoeCommand;

import com.aor.CrossingGuardJoe.model.game.elements.Joe;

public class JoeRaisingStopSign implements CommandJoe{
    private final Joe joe;

    public JoeRaisingStopSign(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.startRaisingStopSign();
    }

}
