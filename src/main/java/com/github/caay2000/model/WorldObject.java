package com.github.caay2000.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public abstract class WorldObject {

    private final Position position;

    protected WorldObject(Position position) {
        this.position = position;
    }

    protected Position getPosition() {
        return position;
    }

    public abstract void update();

    public double distanceTo(WorldObject to) {
        return this.position.distanceTo(to.getPosition());
    }

}
