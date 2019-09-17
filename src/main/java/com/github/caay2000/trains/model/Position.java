package com.github.caay2000.trains.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Position {

    private final double x;
    private final double y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //TODO should be removed ?
    public double getX() {
        return x;
    }

    //TODO should be removed ?
    public double getY() {
        return y;
    }

    public double distanceTo(Position to) {
        return Math.hypot(x - to.x, y - to.y);
    }

    public Position move(double x, double y) {
        return new Position(this.x + x, this.y + y);
    }
}
