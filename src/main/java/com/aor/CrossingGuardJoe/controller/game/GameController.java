package com.aor.CrossingGuardJoe.controller.game;

import com.aor.CrossingGuardJoe.controller.Controller;
import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Element;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }

    public boolean isInRange(Element element1, Element element2) {
        return element1.getPosition().getX() <= element2.getPosition().getX() + 8 &&
                element1.getPosition().getX() >= element2.getPosition().getX() - 28;
    }
}
