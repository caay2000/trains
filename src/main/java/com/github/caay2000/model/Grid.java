package com.github.caay2000.model;

import java.security.SecureRandom;
import java.util.Random;

public class Grid {

    public static final Integer GRID_SIZE = 25;
    public static final Integer MINIMUM_DISTANCE_BETWEEN_CITIES = 3;
    public static final Integer MAXIMUM_CONNECTION_DISTANCE_BETWEEN_CITIES = GRID_SIZE / 3;

    private static Grid instance;
    private final Random random;

    private Grid() {
        this.random = new SecureRandom();
    }

    public static Grid getInstance() {
        if (instance == null) {
            instance = new Grid();
        }
        return instance;
    }

    public Position getRandomPosition() {
        return new Position(getRandomIntX(), getRandomIntY());
    }

    private int getRandomIntX() {
        return random.ints(0, GRID_SIZE + 1).limit(1).findFirst().getAsInt();

    }

    private int getRandomIntY() {
        return random.ints(0, GRID_SIZE + 1).limit(1).findFirst().getAsInt();

    }

}
