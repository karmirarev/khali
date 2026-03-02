package com.your.mom;

import java.util.HashMap;

public class LevelGenerator {
    private Room room;
    private Position position;
    HashMap<Position, Room> roomMap = new HashMap<Position, Room>();

    public LevelGenerator(Room room, Position position) {
        this.room = room;
    }

    // create the starting room
    // when game starts call this with event listener?
    public void SetRoom(Room room, Position position) {
        if (!roomMap.containsKey(position)) {
            roomMap.put(position, new Room());
            SetDoors();
        }
        GenerateNeighborRooms();
        // further: check game state and update the new room generation
    }

    public void GenerateNeighborRooms() {
        // generate the 4 neighboring rooms
    }

    public void SetDoors() {
        if (roomMap.size() == 1) {
            // set the 4 doors

        }
        else {
            // checksides from position
            // check free busy sides
            // place the doors according to the new calculation
        }
    }
}
