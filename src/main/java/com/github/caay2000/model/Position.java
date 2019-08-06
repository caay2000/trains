package com.github.caay2000.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Position {

    public static final double POSITION_DELTA = 0.01d;

    private float x;
    private float y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position to) {
        return Math.hypot(x - to.x, y - to.y);
    }

    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }


}
