package com.aor.CrossingGuardJoe.model.game;

import com.aor.CrossingGuardJoe.model.game.elements.Car;
import com.aor.CrossingGuardJoe.model.game.elements.Joe;
import com.aor.CrossingGuardJoe.model.game.elements.Kid;

import java.util.List;

public class Road {
    private Joe joe;
    private List<Kid> kids;
    private List<Car> cars;

    public Road() {}

    public Joe getJoe() { return joe; }
    public List<Kid> getKids() { return kids; }
    public List<Car> getCars() { return cars; }

    public void setJoe(Joe joe) { this.joe = joe; }
    public void setKids(List<Kid> kids) { this.kids = kids;}
    public void setCars(List<Car> cars) { this.cars = cars; }


}
