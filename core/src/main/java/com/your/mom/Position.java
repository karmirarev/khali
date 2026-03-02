package com.your.mom;

public class Position {
    private int x;
    private int y;

    enum Side {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void IterateSides() {

    }
}
