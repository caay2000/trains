package com.github.caay2000.trains.model;

public final class Constants {

    public static final Double DEFAULT_SIMULATION_TIME_FACTOR = 1000d / 60d;

    public static final Double POSITION_DELTA = 0.01d;

    public static final Integer GRID_SIZE = 25;
    public static final Integer CITY_MIN_DISTANCE_BETWEEN_CITIES = 3;
    public static final Integer CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES = GRID_SIZE / 3;

    private Constants() {
    }
}
