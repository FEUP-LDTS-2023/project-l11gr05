package com.CrossingGuardJoe.model.game.elements.KidCommand;

import com.CrossingGuardJoe.model.game.elements.Command;
import com.CrossingGuardJoe.model.game.elements.Kid;

public class KidStopCommand implements Command {
    private final Kid kid;

    public KidStopCommand(Kid kid) {
        this.kid = kid;
    }

    @Override
    public void execute() {
        kid.isNotWalking();
    }
}
