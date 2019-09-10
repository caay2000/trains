package com.github.caay2000.trains.model;

import java.util.Random;

public class WorldGenerator {

    private final Random random;

    public WorldGenerator(Random random) {
        this.random = random;
    }

    public World generate(int numberOfCities) {

        World world = new World();
        for (int i = 0; i < numberOfCities; i++) {
            City newCity = createRandomCity();
            if (newCityIsSuitable(world, newCity)) {
                createConnections(world, newCity);
                world.addCity(newCity);
            }
        }
        return world;
    }

    private boolean newCityIsSuitable(World world, City newCity) {
        for (City city : world.getCities()) {
            if (city.distanceTo(newCity) < Constants.CITY_MIN_DISTANCE_BETWEEN_CITIES) {
                return false;
            }
        }
        return true;
    }

    private void createConnections(World world, City newCity) {
        for (City city : world.getCities()) {
            if (city.distanceTo(newCity) < Constants.CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES) {
                world.getRoutes().putEdgeValue(city, newCity, new Route(city, newCity));
                world.getRoutes().putEdgeValue(newCity, city, new Route(newCity, city));
            }
        }
    }

    private City createRandomCity() {
        return City.builder().name("name")
                .population(1)
                .position(randomPosition())
                .build();
    }

    private Position randomPosition() {
        return new Position(random.nextInt(Constants.GRID_SIZE + 1),
                random.nextInt(Constants.GRID_SIZE + 1));
    }
}
