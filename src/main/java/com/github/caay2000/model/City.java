package com.github.caay2000.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(exclude = {"name", "population"}, callSuper = true)
@ToString
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

    public static class Builder {

        public Builder() {
        }

        public City randomCity(Grid grid) {

            String name = "name";
            int population = 1;

            return new City(
                    name,
                    grid.getRandomPosition(),
                    population);
        }
    }
}
