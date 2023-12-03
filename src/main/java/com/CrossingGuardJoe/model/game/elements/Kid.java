package com.CrossingGuardJoe.model.game.elements;

public class Kid extends Element {
    private Command currentCommand;
    private boolean walking = false;
    private boolean hit = false;
    private boolean selected = false;
    private boolean firstHalfOfMovement = true;
    private boolean cannotMove = false;
    private boolean deadCount = false;

    public Kid(int x, int y) {
        super(x, y);
    }

    public void setAndExecuteCommand(Command command) {
        this.currentCommand = command;
        executeCommand();
    }

    private void executeCommand() {
        if (currentCommand != null) {
            currentCommand.execute();
        }
    }

    public void isWalking() {
        walking = true;
    }

    public void isNotWalking() {
        this.walking = false;
        this.firstHalfOfMovement = true;
    }

    public boolean getIsWalkingState() {
        return this.walking;
    }

    public boolean isFirstHalfOfMovement() {
        return this.firstHalfOfMovement;
    }

    public void setFirstHalfOfMovement(boolean firstHalfOfMovement) {
        this.firstHalfOfMovement = firstHalfOfMovement;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected() {
        this.selected = true;
    }

    public void setNotSelected() {
        this.selected = false;
    }

    public void isHit() {
        this.hit = true;
        this.selected = false;
    }

    public boolean getIsHit() { return this.hit;}

    public void setDead() {
        this.deadCount = true;
    }

    public boolean getDeathCount() {
        return this.deadCount;
    }

    public int getPoints() {
        return 100;
    }

    public void setCannotMove() {
        this.cannotMove = true;
    }

    public void setCanMove() {
        this.cannotMove = false;
    }

    public boolean getCanMove() {
        return cannotMove;
    }
}
