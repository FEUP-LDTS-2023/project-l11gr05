package com.CrossingGuardJoe.ViewerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.viewer.game.elements.CarView;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CarViewTest {
    @Test
    void testDraw() {
        GUI gui = mock(GUI.class);
        Car car = new Car(100, 100);
        CarView carView = new CarView();
        carView.draw(car, gui);
        verify(gui).drawImage(eq(car.getPosition()), any(String[].class));
    }
}
