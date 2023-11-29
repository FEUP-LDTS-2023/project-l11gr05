package com.CrossingGuardJoe.controller.game;

import com.CrossingGuardJoe.controller.Controller;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

public abstract class GameController extends Controller<Road> {
    public GameController(Road road) {
        super(road);
    }
}
