package com.CrossingGuardJoe.ViewerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Kid;
import com.CrossingGuardJoe.viewer.game.elements.KidView;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KidViewTest {
    @Test
    void testDraw() {
        GUI gui = mock(GUI.class);
        Kid kid = new Kid(100, 100);
        KidView kidView = new KidView();

        kidView.draw(kid, gui);

        verify(gui).drawImage(eq(kid.getPosition()), any(String[].class));
    }
}
