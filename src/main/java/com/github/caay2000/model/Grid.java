package com.github.caay2000.model;

import java.security.SecureRandom;
import java.util.Random;

import static com.github.caay2000.model.Constants.GRID_SIZE;

public class Grid {


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
        return random.ints(0, Constants.getInteger(GRID_SIZE) + 1)
                .limit(1)
                .findFirst()
                .getAsInt();

    }

    private int getRandomIntY() {
        return random.ints(0, Constants.getInteger(GRID_SIZE) + 1)
                .limit(1)
                .findFirst()
                .getAsInt();

    }

}
