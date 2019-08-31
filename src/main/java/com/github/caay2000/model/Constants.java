package com.github.caay2000.model;

import java.util.HashMap;
import java.util.Map;

public final class Constants {


    public final static String POSITION_DELTA = "POSITION_DELTA";

    public static final String GRID_SIZE = "GRID_SIZE";
    public static final String CITY_MIN_DISTANCE_BETWEEN_CITIES = "MIN_CITY_DISTANCE";
    public static final String CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES = "MAX_CITY_DISTANCE";


    private final static Map<String, Object> map = new HashMap<>();

    static {
        map.put(POSITION_DELTA, 0.01d);
        map.put(GRID_SIZE, 25);
        map.put(CITY_MIN_DISTANCE_BETWEEN_CITIES, 3);
        map.put(CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES, Constants.getInteger(GRID_SIZE) / 3);
    }


    public static Double getDouble(String value) {
        return (Double) map.get(value);
    }

    public static Integer getInteger(String value) {
        return (Integer) map.get(value);
    }


}
