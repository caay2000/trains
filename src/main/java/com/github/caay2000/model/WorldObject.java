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

    public Position getPosition() {
        return position;
    }

    public abstract void update();

//    @Override
//    public boolean equals(Object o) {
//        return EqualsBuilder.reflectionEquals(this, o);
//    }
//
//    @Override
//    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(this);
//    }
//
//    @Override
//    public String toString() {
//        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//    }
}
