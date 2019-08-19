package com.github.caay2000.model;

public class WorldGenerator {

    private final Grid grid;

    public WorldGenerator(Grid grid) {
        this.grid = grid;
    }

    public World generate(int numberOfCities) {

        World world = new World();
        for (int i = 0; i < numberOfCities; i++) {
            City newCity = createRandomCity();
            if (isSuitable(world, newCity)) {
                createConnections(world, newCity);
                world.addCity(newCity);
            }
        }
        return world;
    }

    private boolean isSuitable(World world, City newCity) {
        for (City city : world.getCities()) {
            if (city.distanceTo(newCity) < Grid.MINIMUM_DISTANCE_BETWEEN_CITIES) {
                return false;
            }
        }
        return true;
    }

    private void createConnections(World world, City newCity) {
        for (City city : world.getCities()) {
            if (city.distanceTo(newCity) < Grid.MAXIMUM_CONNECTION_DISTANCE_BETWEEN_CITIES) {
                world.getRoutes().putEdgeValue(city, newCity, new Route(city, newCity));
                world.getRoutes().putEdgeValue(newCity, city, new Route(newCity, city));
            }
        }
    }

    private City createRandomCity() {
        return new City.Builder(grid).randomCity();
    }

}