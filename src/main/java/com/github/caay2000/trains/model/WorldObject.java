package com.github.caay2000.trains.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
@EqualsAndHashCode
public abstract class WorldObject {

    protected final Position position;

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
