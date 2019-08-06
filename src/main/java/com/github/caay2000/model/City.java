package com.github.caay2000.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class City extends WorldObject {

    public City(Position position) {
        super(position);
    }

    @Override
    public void update() {

    }
}
