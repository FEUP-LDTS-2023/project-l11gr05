package com.CrossingGuardJoe.viewer.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.viewer.images.JoeImages;

public class JoeView extends ElementViewer<Joe> {
    @Override
    public void draw(Joe joe, GUI gui) {
        if (joe.getIsWalkingState()) {
            if (joe.isFirstHalfOfMovement()) {
                if (joe.getIsWalkingToLeft()) {
                    gui.drawImage(joe.getPosition(), JoeImages.JOE_WALKLEFT);
                } else {
                    gui.drawImage(joe.getPosition(), JoeImages.JOE_WALKRIGHT);
                }
            }
            else {
                gui.drawImage(joe.getPosition(), JoeImages.JOE_WALKSECONDHALF);
            }
            joe.setFirstHalfOfMovement(!joe.isFirstHalfOfMovement());
        }
        else if (joe.getIsRaisingStopSign()) {
            gui.drawImage(joe.getPosition(), JoeImages.JOE_STOP);
        }
        else if (joe.getIsPassSign()) {
            gui.drawImage(joe.getPosition(), JoeImages.JOE_PASS);
        }
        else {
            gui.drawImage(joe.getPosition(), JoeImages.JOE_STAND);
        }
    }
}