package com.github.caay2000.trains.model;

import com.github.caay2000.trains.model.world.City;

public class Route {

    private final City startCity;
    private final City endCity;

    public Route(City startCity, City endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }
}
