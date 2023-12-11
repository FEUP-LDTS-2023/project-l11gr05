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

import static org.junit.jupiter.api.Assertions.*;
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

        roadController = new RoadController(road);
    }

    @Test
    public void nexActionScoreTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(joe.getScore()).thenReturn(10);
        when(game.getHighestScore()).thenReturn(0);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game).setHighestScore(joe.getScore());

        when(joe.getScore()).thenReturn(10);
        when(game.getHighestScore()).thenReturn(10);
        assertEquals(joe.getScore(), game.getHighestScore());
    }

    @Test
    public void nexActionNotScoreTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(joe.getScore()).thenReturn(0);
        when(game.getHighestScore()).thenReturn(10);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);

        assertEquals(10, game.getHighestScore());
        verify(game, times(0)).setHighestScore(joe.getScore());
    }

    @Test
    public void nextActionLevelTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(road.getCurrentLevel()).thenReturn(2);
        when(game.getHighestLevel()).thenReturn(1);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);

        verify(game).setHighestLevel(road.getCurrentLevel());

        when(road.getCurrentLevel()).thenReturn(2);
        when(game.getHighestLevel()).thenReturn(2);
        assertEquals(road.getCurrentLevel(), game.getHighestLevel());
    }

    @Test
    public void nextActionNotLevelTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(road.getCurrentLevel()).thenReturn(1);
        when(game.getHighestLevel()).thenReturn(2);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);

        assertEquals(2, game.getHighestLevel());
        verify(game, times(0)).setHighestLevel(road.getCurrentLevel());
    }

    @Test
    public void nextActionEscTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        when(joe.getPosition()).thenReturn(new Position(100, 100));
        roadController.nextAction(game, GUI.ACTION.LEFT, initialTime);

        when(joe.getIsWalkingState()).thenReturn(true);
        assertTrue(joe.getIsWalkingState());

        when(joe.getIsWalkingState()).thenReturn(false);
        when(gui.getNextAction()).thenReturn(GUI.ACTION.ESC);
        roadController.nextAction(game, GUI.ACTION.ESC, initialTime);
        assertFalse(joe.getIsWalkingState());
    }

    /*@Test
    public void nextActionNotEscTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        when(joe.getPosition()).thenReturn(new Position(100, 100));
        roadController.nextAction(game, GUI.ACTION.LEFT, initialTime);

    }*/

    @Test
    public void nextActionHearts0Test() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(joe.getHearts()).thenReturn(0);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game, atLeastOnce()).popState();
        verify(game, atLeastOnce()).setState(any(GameOverState.class));
    }

    @Test
    public void nextActionGameEndedTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(road.isGameEnded()).thenReturn(true);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game, atLeastOnce()).popState();
        verify(game, atLeastOnce()).setState(any(GameOverState.class));
    }

    @Test
    public void nextActionGameNotEndedTest() throws IOException {
        long initialTime = System.currentTimeMillis();
        when(road.getJoe()).thenReturn(joe);

        when(road.isGameEnded()).thenReturn(false);
        roadController.nextAction(game, GUI.ACTION.NONE, initialTime);
        verify(game, atLeastOnce()).popState();
    }
}
