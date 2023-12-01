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
        int randomY;
        for (int i = 0; i < 3; i++) {
            do {
                randomY = -rand.nextInt(500) - rand.nextInt(500);
            } while (AuxCarCheck.isAnyCarOverlapping(randomY, cars, 200));

            Car car = new Car(xValues[rand.nextInt(xValues.length)], randomY);
            cars.add(car);
        }

        new Thread(() -> {
            Random rand = new Random();

            while (true) {
                synchronized (cars) {
                    for (Car car : cars) {
                        if (car.getPosition().getY() > 500) {
                            int newRandomY;

                            do {
                                newRandomY = -rand.nextInt(500) - rand.nextInt(500);
                            } while (AuxCarCheck.isAnyCarOverlapping(newRandomY, cars, 200));

                            car.getPosition().setY(newRandomY);
                            car.getPosition().setX(xValues[rand.nextInt(xValues.length)]);
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return cars;
    }

    private List<Kid> createKids() {
        List<Kid> kids = new ArrayList<>();
        int x = 400;

        for (int i = 0; i < 3; i++) {
            Kid kid = new Kid(x, 330);
            kids.add(kid);
            x += 10;
        }
        return kids;
    }
}
