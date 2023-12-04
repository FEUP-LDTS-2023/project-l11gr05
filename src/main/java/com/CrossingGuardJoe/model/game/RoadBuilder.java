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
    private static final int JOE_INITIAL_X = 390;
    private static final int JOE_Y = 297;
    private static final int[] ROAD_LANES = {85, 172, 259, 346};
    private static final int NUMBER_OF_CARS = 3;
    private static final int DISTANCE_BETWEEN_CARS = 200;
    private static final int RANDOM_BOUND = 500;
    private static final int MAX_Y_DISTANCE = 500;
    private static final int NUMBER_OF_KIDS = 3;
    private static final int KID_SPAWN_X = 430;
    private static final int KID_Y = 330;
    private static final int MIN_KID_DISTANCE = 9;

    public Road createRoad() {
        Road road = new Road();

        road.setJoe(createJoe());
        road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    private Joe createJoe() {
        return new Joe(JOE_INITIAL_X, JOE_Y);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        int randomY;
        for (int i = 0; i < NUMBER_OF_CARS; i++) {
            do {
                randomY = -rand.nextInt(RANDOM_BOUND) - rand.nextInt(RANDOM_BOUND);
            } while (AuxCarCheck.isAnyCarOverlapping(randomY, cars, DISTANCE_BETWEEN_CARS));

            Car car = new Car(ROAD_LANES[rand.nextInt(ROAD_LANES.length)], randomY);
            cars.add(car);
        }

        new Thread(() -> {
            Random rand = new Random();

            while (true) {
                synchronized (cars) {
                    for (Car car : cars) {
                        if (car.getPosition().getY() > MAX_Y_DISTANCE) {
                            int newRandomY;

                            do {
                                newRandomY = -rand.nextInt(RANDOM_BOUND) - rand.nextInt(RANDOM_BOUND);
                            } while (AuxCarCheck.isAnyCarOverlapping(newRandomY, cars, DISTANCE_BETWEEN_CARS));

                            car.getPosition().setY(newRandomY);
                            car.getPosition().setX(ROAD_LANES[rand.nextInt(ROAD_LANES.length)]);
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
        int x = KID_SPAWN_X;

        for (int i = 0; i < NUMBER_OF_KIDS; i++) {
            Kid kid = new Kid(x, KID_Y);
            kids.add(kid);
            x += MIN_KID_DISTANCE;
        }
        return kids;
    }

    public List<Kid> createKidsNextLevel(int numberKids) {
        List<Kid> kids = new ArrayList<>();
        int x = KID_SPAWN_X;

        for (int i = 0; i < numberKids; i++) {
            Kid kid = new Kid(x, KID_Y);
            kids.add(kid);
            x += MIN_KID_DISTANCE;
        }
        return kids;
    }
}
