package com.your.mom.core;

import java.util.Random;

public class DungeonGenerator {
    int[] roomOne = {1, 0, 0, 0};
    int[] roomTwo = {0, 1, 0, 0};
    int[] roomThree = {0, 0, 1, 0};
    int[] roomFour = {0, 0, 0, 1};
    int[] roomFive = {1, 1, 0, 0};
    int[] roomSix = {0, 1, 1, 0};
    int[] roomSeven = {0, 0, 1, 1};
    int[] roomEight = {1, 0, 0, 1};
    int[] roomNine = {0, 1, 0, 1};
    int[] roomTen = {1, 0, 1, 0};
    int[] roomEleven = {1, 1, 0, 1};
    int[] roomTwelve = {1, 1, 1, 0};
    int[] roomThirty = {0, 1, 1, 1};
    int[] roomForty = {1, 0, 1, 1};
    int[] roomFifty = {1, 1, 1, 1};

    int[][] rooms = {roomOne, roomTwo, roomThree, roomFour,
        roomFive,  roomSix, roomSeven, roomEight, roomNine,
        roomTen, roomEleven, roomTwelve, roomThirty, roomForty, roomFifty};

    int[][] grid = new int[5][5];

    // rules
    // first digit of the array can only attach to third digit if both are one
    // second digit of the array can only attach to fourth digit if both are one

    public void CheckEntropy() {
        Random random = new Random();
        int randomIndex = random.nextInt(rooms.length);

        if (grid.length == 0) {
            grid[0][0] = rooms[randomIndex];
        } else {
            // check entropy
        }
    }

    public void Collapse() {

    }
}
