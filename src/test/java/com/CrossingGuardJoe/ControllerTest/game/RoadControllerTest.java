package com.CrossingGuardJoe.ControllerTest.game;

import com.CrossingGuardJoe.Game;
import com.CrossingGuardJoe.controller.game.RoadController;
import com.CrossingGuardJoe.controller.game.elements.CarController;
import com.CrossingGuardJoe.controller.game.elements.JoeController;
import com.CrossingGuardJoe.controller.game.elements.KidController;
import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.Road;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.states.menu.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RoadControllerTest {
    private Road road;
    private Joe joe;
    private Car car;
    private Kid kid;
    private Game game;
    private GUI gui;
    private RoadController roadController;
    private JoeController joeController;
    private KidController kidController;
    private CarController carController;

    @BeforeEach
    public void setUp() {
        road = mock(Road.class);
        joe = mock(Joe.class);
        car = mock(Car.class);
        kid = mock(Kid.class);
        game = mock(Game.class);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        List<Kid> kids = new ArrayList<>();
        kids.add(kid);
        gui = mock(GUI.class);

        joeController = mock(JoeController.class);
        kidController = mock(KidController.class);
        carController = mock(CarController.class);

        roadController = new RoadController(road);
    }

    @Test
    public void nexActionTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);
        when(joe.getScore()).thenReturn(10);
        when(game.getHighestScore()).thenReturn(0);

        when(road.getCurrentLevel()).thenReturn(2);
        when(game.getHighestLevel()).thenReturn(1);

        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);

        verify(game).setHighestScore(joe.getScore());
        verify(game).setHighestLevel(road.getCurrentLevel());

        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        when(joe.getPosition()).thenReturn(new Position(100, 100));
        roadController.nextAction(game, GUI.ACTION.LEFT, initialTime);
        when(joe.getIsWalkingState()).thenReturn(true);
        assertTrue(joe.getIsWalkingState());

        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        when(joe.getIsWalkingState()).thenReturn(false);
        assertFalse(joe.getIsWalkingState());
        roadController.nextAction(game, GUI.ACTION.ESC, initialTime);

        when(joe.getHearts()).thenReturn(0);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game, atLeastOnce()).popState();
        verify(game, atLeastOnce()).setState(any(GameOverState.class));

        when(road.isGameEnded()).thenReturn(true);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game, atLeastOnce()).popState();
        verify(game, atLeastOnce()).setState(any(GameOverState.class));
    }
}
