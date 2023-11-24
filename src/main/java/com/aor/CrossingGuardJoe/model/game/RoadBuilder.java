package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoadBuilder {
    private final Random rand = new Random();
    public Road createRoad() {
        Road road = new Road(1000, 500);

        road.setJoe(createJoe());
        //road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    private Joe createJoe() {
        return new Joe(400, 300);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int randomY = -rand.nextInt(500);
            int randomInterval = rand.nextInt(5000) + 5000;
            Car car = new Car(200, randomY);
            cars.add(car);
        }
        return cars;
    }
    //missing all others elements creater
}
