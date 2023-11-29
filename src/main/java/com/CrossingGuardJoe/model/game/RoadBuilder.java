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

    private boolean isCarOverlapping(int newY, int existingY, int minDistance) {
        return Math.abs(newY - existingY) < minDistance;
    }

    private boolean isAnyCarOverlapping(int newY, List<Car> cars, int minDistance) {
        for (Car existingCar : cars) {
            if (isCarOverlapping(newY, existingCar.getPosition().getY(), minDistance)) {
                return true;
            }
        }
        return false;
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        int[] xValues = {85, 172, 259, 346};

        for (int i = 0; i < 3; i++) {
            int randomY = -rand.nextInt(500) - rand.nextInt(500);

            for (Car existingCar : cars) {
                while (isCarOverlapping(randomY, existingCar.getPosition().getY(), 200)) {
                    randomY = -rand.nextInt(500) - rand.nextInt(500);
                }
            }

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
                            } while (isAnyCarOverlapping(newRandomY, cars, 200));

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
        int x = 440;

        for (int i = 0; i < 1; i++) {
            Kid kid = new Kid(x, 330);
            kids.add(kid);
            x += 15;
        }
        return kids;
    }
}
