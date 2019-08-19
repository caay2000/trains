package com.github.caay2000.model;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class World {

    private final Grid grid = Grid.getInstance();
    private final Set<City> cities = new HashSet<>();
    private final MutableValueGraph<City, Route> routes = ValueGraphBuilder.directed().build();

    public World() {
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
