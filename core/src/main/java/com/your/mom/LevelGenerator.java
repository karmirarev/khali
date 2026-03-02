package com.your.mom;

import java.util.HashMap;

public class LevelGenerator {
    private Room room;
    private Position position;
    HashMap<Position, Room> roomMap = new HashMap<Position, Room>();

    public LevelGenerator(Room room, Position position) {
        this.room = room;
    }

    // create the starting room at (0, 0)
    public void SetRoom(Room room, Position position) {
        if (!roomMap.containsKey(position)) {
            roomMap.put(position, new Room());
        }
    }

    // generate the 4 neighboring rooms
    // add to the grid or whatever
    // call checksides from position
    // check free busy sides
    // and place the doors according to the new calculation

    // further: check game state and update the new room generation

}
