package com.CrossingGuardJoe.ViewerTest.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.Position;
import com.CrossingGuardJoe.model.menu.InstructionsMenu;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;
import com.CrossingGuardJoe.viewer.menu.InstructionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class InstructionsMenuViewerTest {
    InstructionsMenu instructionsMenuMock;
    GUI guiMock;
    InstructionsMenuViewer instructionsMenuViewer;

    String[] ARROW_DOWN = {
            "$$$$$$$$$$$$$$$$",
            "$$GGGGGGGGGGGG$$",
            " $GGGGGGGGGGGG$ ",
            " $$GGGGGGGGGG$$ ",
            "  $$GGGGGGGG$$  ",
            "   $GGGGGGGG$   ",
            "   $$GGGGGG$$   ",
            "    $GGGGGG$    ",
            "    $$GGGG$$    ",
            "     $GGGG$     ",
            "     $$GG$$     ",
            "      $GG$      ",
            "      $$$$      ",
            "       $$       ",
            "       $$       ",
    };

    String[] KEY_UP = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$KKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_DOWN = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$KKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$KKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKK$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_RIGHT = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$KKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$KKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$KKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$KKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$KKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$KKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$KKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$KKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$KKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$KKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_LEFT = {
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKK$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKK$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKK$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKK$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKK$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKK$$$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKK$$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKK$$$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKK$$$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKK$$$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKK$$$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKK$$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKK$$$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKK$$$KKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$KKKK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$KK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$KK$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "$$$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$$$",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
            "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  ",
    };

    String[] KEY_ESC = {
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$KKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$$$$$$KKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$KKKKKKK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKK$$$$$$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$KKKKKKKKKKKKK$$KK$$KKKKKKKKKK$$",
            "$$KKKK$$$$$$$$KK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKK$$$$$$$$KK$$$$$$$KK$$$$$$$$KKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
    };

    @BeforeEach
    void init() {
        instructionsMenuMock = mock(InstructionsMenu.class);
        guiMock = mock(GUI.class);
        instructionsMenuViewer = new InstructionsMenuViewer(instructionsMenuMock);
        Mockito.when(instructionsMenuMock.getTotalPages()).thenReturn(5);
    }

    @Test
    void elementsDraw() {
        instructionsMenuViewer.drawTitle(guiMock);
        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Instructions"), Mockito.eq("#FFFFFF"));

        for (int i = 0; i <= 5; i++) {

            Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(i);

            instructionsMenuViewer.drawInformation(guiMock);

            verify(guiMock).drawText(Mockito.any(), Mockito.eq("Page"), Mockito.eq("#FFFFFF"));
            verify(guiMock).drawText(Mockito.any(), Mockito.eq("of"), Mockito.eq("#FFFFFF"));
            verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#FFFFFF"));

            if (i == 5) {
                verify(guiMock).drawText(Mockito.any(), Mockito.eq(i), Mockito.eq("#D30000"));
            } else {
                verify(guiMock).drawText(Mockito.any(), Mockito.eq(i), Mockito.eq("#FFFFFF"));
            }
        }
    }

    @Test
    void titleDraw() {
        instructionsMenuViewer.drawTitle(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Instructions"), Mockito.eq("#FFFFFF"));
    }

    @Test
    void informationDraw() {
        Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(3);

        instructionsMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Page"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq("of"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(3), Mockito.eq("#FFFFFF"));
    }

    @Test
    void informationLastPageDraw() {
        Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(3);

        instructionsMenuViewer.drawInformation(guiMock);

        verify(guiMock).drawText(Mockito.any(), Mockito.eq("Page"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq("of"), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(5), Mockito.eq("#FFFFFF"));
        verify(guiMock).drawText(Mockito.any(), Mockito.eq(3), Mockito.eq("#FFFFFF"));
    }

    @Test
    void testDrawPageOne() {
        Mockito.when(instructionsMenuMock.getCurrentPage()).thenReturn(1);
        instructionsMenuViewer.drawElements(guiMock);

        instructionsMenuViewer.drawElements(guiMock);

        // Verify text drawing at specific positions
        Mockito.verify(guiMock, times(2)).drawText(Mockito.any(), eq("you are Joe"), eq("#FFFFFF"));
        Mockito.verify(guiMock, times(2)).drawText(Mockito.any(), eq("a crossing guard"), eq("#FFFFFF"));
        Mockito.verify(guiMock, times(2)).drawText(Mockito.any(), eq("click once to move"), eq("#FFFFFF"));

        // Verify Joe images drawing
        Mockito.verify(guiMock).drawImage(new Position(150, 190), JoeImages.JOE_STAND);
        Mockito.verify(guiMock).drawImage(new Position(230, 190), JoeImages.JOE_WALKLEFT);
        Mockito.verify(guiMock).drawImage(new Position(310, 190), JoeImages.JOE_WALKRIGHT);

        // Verify key images drawing
        Mockito.verify(guiMock).drawImage(new Position(235, 310), KEY_LEFT);
        Mockito.verify(guiMock).drawImage(new Position(315, 310), KEY_RIGHT);

        // Verify that no other methods are called on the GUI mock
        Mockito.verifyNoMoreInteractions(guiMock);
    }

}
