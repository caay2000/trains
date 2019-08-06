package com.github.caay2000.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class World {

    private static final Integer GRID_SIZE = 25;

    private final Set<City> cities = new HashSet<>();

    public Set<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public static class Builder {

        private final Random random = new Random();
        private int numberOfCities;

        public Builder withNumberOfCities(int num) {
            this.numberOfCities = num;
            return this;
        }

        public World build() {
            World world = new World();
            for (int i = 0; i < numberOfCities; i++) {
                world.addCity(createRandomCity());
            }
            return world;
        }

        private City createRandomCity() {
            return new City(
                    new Position(
                            random.ints(0, GRID_SIZE + 1).limit(1).findFirst().getAsInt(),
                            random.ints(0, GRID_SIZE + 1).limit(1).findFirst().getAsInt()));
        }
    }
}
