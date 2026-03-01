package com.your.mom;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int index;
    private Room currentRoom;
    private Door door;

    ArrayList<Room> roomList = new ArrayList<Room>();

    public Room(int index)
    {
        this.index = index;
    }

    private void GenerateRoom()
    {
        Room startingRoom = new Room(0);
        roomList.add(startingRoom);

        // define current room with player?

        if (currentRoom == startingRoom) {
            // base case: place top, bottom, left, right doors

            // generate the 4 layer 1 rooms like this?
            // wait no maybe we can use 2d arrays
            // aaaa
            for (int i = 1; i < 5; i++) {
                Room layerOneRoom = new Room(i);
                roomList.add(layerOneRoom);
            }
        } else {

        }


    }

    private void PlaceDoor() {
        // check free side or busy side
        // place door in correct coordinates
        // maybe make child of floor? to have position dependency

    }


}
