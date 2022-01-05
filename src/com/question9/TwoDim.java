package com.question9;

public class TwoDim {
    private int x;
    private int y;
    public TwoDim() {
        this.x = 0;
        this.y = 0;
    }
    public TwoDim(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Coordinate: x = " + x + " y = " + y;
    }
}
