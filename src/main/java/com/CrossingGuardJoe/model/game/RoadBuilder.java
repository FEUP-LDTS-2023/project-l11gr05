package com.CrossingGuardJoe.model.game;

import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoadBuilder {
    private final Random rand = new Random();
    public Road createRoad() {
        Road road = new Road();

        road.setJoe(createJoe());
        road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    private Joe createJoe() {
        return new Joe(390, 297);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        int[] xValues = {85, 172, 259, 346};

        int randomY = -rand.nextInt(500);
        for (int i = 0; i < 3; i++) {
            Car car = new Car(xValues[rand.nextInt(xValues.length)], randomY);
            randomY -= rand.nextInt(500) + 150;
            cars.add(car);
        }

        new Thread(() -> {
            Random rand = new Random();

            while (true) {
                synchronized (cars) {
                    for (Car car : cars) {
                        if (car.getPosition().getY() > 500) {
                            car.getPosition().setY(-rand.nextInt(500));
                            car.getPosition().setX(xValues[rand.nextInt(xValues.length)]);
                        }
                    }
                }

                try {
                    Thread.sleep(rand.nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return cars;
    }



    private List<Kid> createKids() {
        List<Kid> kids = new ArrayList<>();
        int x = 440;

        for (int i = 0; i < 1; i++) {
            Kid kid = new Kid(x, 330);
            kids.add(kid);
            x += 15;
        }
        return kids;
    }
}
