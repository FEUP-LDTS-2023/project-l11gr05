package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.Road;
import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;
import com.aor.CrossingGuardJoe.model.game.elements.Kid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoadBuilder {
    private final Random rand = new Random();
    public Road createRoad() {
        Road road = new Road(1000, 500);

        road.setJoe(createJoe());
        road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    private Joe createJoe() {
        return new Joe(400, 300);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        Random rand = new Random();

        int randomY = -rand.nextInt(500);
        int intervalOffset = 200;
        for (int i = 0; i < 5; i++) {
            Car car = new Car(200, randomY);
            cars.add(car);

            randomY -= (rand.nextInt(500) + intervalOffset);
        }
        return cars;
    }

    private List<Kid> createKids() {
        List<Kid> kids = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Kid kid = new Kid(440, 330);
            kids.add(kid);
        }
        return kids;
    }
}
