package com.github.caay2000.trains.model.world;

import java.util.HashSet;
import java.util.Set;

import com.github.caay2000.trains.model.Route;
import com.github.caay2000.trains.model.world.City;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class World {

    private final Set<City> cities;
    private final MutableValueGraph<City, Route> routes;

    public World() {
        this.cities = new HashSet<>();
        this.routes = ValueGraphBuilder.directed().build();
    }

    public MutableValueGraph<City, Route> getRoutes() {
        return routes;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }
}
