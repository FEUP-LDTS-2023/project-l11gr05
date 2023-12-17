package com.CrossingGuardJoe.viewer.game.elements;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.viewer.images.defined.JoeImages;

public class JoeView extends ElementViewer<Joe> {
    @Override
    public void draw(Joe joe, GUI gui) {
        if (joe.getIsHit()) {
            if (joe.getHitLeft()) {
                gui.drawImage(joe.getPosition(), JoeImages.getJoeHitleftImage());
            } else {
                gui.drawImage(joe.getPosition(), JoeImages.getJoeHitrightImage());
            }
            joe.isNotHit();
        }
        else if (joe.getIsWalkingState()) {
            if (joe.isFirstHalfOfMovement()) {
                if (joe.getIsWalkingToLeft()) {
                    gui.drawImage(joe.getPosition(), JoeImages.getJoeWalkleftImage());
                } else {
                    gui.drawImage(joe.getPosition(), JoeImages.getJoeWalkrightImage());
                }
            }
            else {
                gui.drawImage(joe.getPosition(), JoeImages.getJoeWalksecondhalfImage());
            }
            joe.setFirstHalfOfMovement(!joe.isFirstHalfOfMovement());
        }
        else if (joe.getIsRaisingStopSign()) {
            gui.drawImage(joe.getPosition(), JoeImages.getJoeStopImage());
        }
        else if (joe.getIsPassSign()) {
            gui.drawImage(joe.getPosition(), JoeImages.getJoePassImage());
        }
        else {
            gui.drawImage(joe.getPosition(), JoeImages.getJoeStandImage());
        }
    }
}
