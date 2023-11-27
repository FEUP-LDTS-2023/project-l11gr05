package com.CrossingGuardJoe.ViewerTest.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.viewer.game.elements.JoeView;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JoeViewTest {
    @Test
    void testDraw() {
        GUI gui = mock(GUI.class);
        Joe joe = new Joe(100, 100);
        JoeView joeView = new JoeView();

        joeView.draw(joe, gui);

        verify(gui).drawImage(eq(joe.getPosition()), any(String[].class));
    }
}
