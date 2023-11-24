package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoaderRoadBuilder extends RoadBuilder{

    @Override
    protected int getWidth() {
        return 0;
    }

    @Override
    protected int getHeight() {
        return 0;
    }

    @Override
    protected Joe createJoe() {
        return new Joe(100,100);
    }

    private final Random rand = new Random();

    @Override
    protected List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int randomY = -rand.nextInt(500);

            int randomInterval = rand.nextInt(5000) + 5000;

            // Create car with random Y-axis position
            Car car = new Car(200, randomY);

            cars.add(car);
        }


        return cars;
    }


}
