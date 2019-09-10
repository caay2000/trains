package com.github.caay2000.trains.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
@EqualsAndHashCode(exclude = {"name", "population"}, callSuper = true)
final public class City extends WorldObject {

    private final String name;
    private int population;

    public City(String name, Position position, int population) {
        super(position);
        this.name = name;
        this.population = population;
    }

    @Override
    public void update() {

    }
}
