package com.your.mom;

import com.badlogic.gdx.graphics.Texture;

public class Door {
    private float xPos;
    private float yPos;
    private Texture door;

    public Door() {
        this.xPos = xPos;
        this.yPos = yPos;

        door = new Texture("door.png");
    }

    private void PlaceDoor() {
        // check free side or busy side
        // place door in correct coordinates
        // maybe make child of floor? to have position dependency

    }

}
