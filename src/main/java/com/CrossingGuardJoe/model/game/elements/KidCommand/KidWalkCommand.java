package com.CrossingGuardJoe.model.game.elements.KidCommand;

import com.CrossingGuardJoe.model.game.elements.Command;
import com.CrossingGuardJoe.model.game.elements.Kid;

public class KidWalkCommand implements Command {
    private final Kid kid;

    public KidWalkCommand(Kid kid) {
        this.kid = kid;
    }

    @Override
    public void execute() {
        kid.isWalking();
    }
}
