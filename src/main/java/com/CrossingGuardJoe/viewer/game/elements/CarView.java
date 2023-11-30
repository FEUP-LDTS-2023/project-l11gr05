package com.CrossingGuardJoe.viewer.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.viewer.images.CarImage;

public class CarView extends ElementViewer<Car> {

    @Override
    public void draw(Car car, GUI gui) {
        gui.drawImage(car.getPosition(), CarImage.CAR);
    }
}
