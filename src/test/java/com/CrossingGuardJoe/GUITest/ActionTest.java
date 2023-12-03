package com.CrossingGuardJoe.GUITest;

import com.CrossingGuardJoe.gui.GUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    @Test
    public void testEnumValuesExistence() {
        for (GUI.ACTION action : GUI.ACTION.values()) {
            assertNotNull(action);
        }
    }
}
