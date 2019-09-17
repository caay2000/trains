package com.github.caay2000.trains.model.world;

import com.github.caay2000.trains.model.Position;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
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
