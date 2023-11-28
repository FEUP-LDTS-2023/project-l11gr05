package com.CrossingGuardJoe.model.game.elements.JoeCommand;

import com.CrossingGuardJoe.model.game.elements.Joe;

public class JoeRaisingPassSign implements CommandJoe{
    private final Joe joe;

    public JoeRaisingPassSign(Joe joe) {
        this.joe = joe;
    }

    @Override
    public void execute() {
        joe.startRaisingPassSign();
    }

}
