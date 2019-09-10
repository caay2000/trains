package com.github.caay2000.trains.model;

import static com.github.caay2000.trains.model.Constants.CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES;
import static com.github.caay2000.trains.model.Constants.CITY_MIN_DISTANCE_BETWEEN_CITIES;
import static com.github.caay2000.trains.model.Constants.GRID_SIZE;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorldGeneratorTest {

    private static final Position POSITION_START = new Position(0, 0);
    private static final Position POSITION_SHORT = new Position(Constants.CITY_MIN_DISTANCE_BETWEEN_CITIES - 1, 0);
    private static final Position POSITION_OK = new Position(Constants.CITY_MIN_DISTANCE_BETWEEN_CITIES + 1, 0);
    private static final Position POSITION_LONG = new Position(Constants.CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES + 1, 0);

    @Mock
    private Random random;

    @Test
    public void shortDistanceIsNotSuitable() {

        when(random.nextInt(GRID_SIZE + 1)).thenReturn(0, 0, 1, 0);

        WorldGenerator testee = new WorldGenerator(random);

        World world = testee.generate(2);
        Assert.assertEquals(1, world.getCities().size());
    }

    @Test
    public void twoCitiesCreated() {

        when(random.nextInt(GRID_SIZE + 1)).thenReturn(0, 0, CITY_MIN_DISTANCE_BETWEEN_CITIES + 1, 0);

        WorldGenerator testee = new WorldGenerator(random);

        World world = testee.generate(2);
        Assert.assertEquals(2, world.getCities().size());
    }

    @Test
    public void twoCitiesCreatedButNotConnectedWhenDistanceIsTooLong() {

        when(random.nextInt(GRID_SIZE + 1)).thenReturn(0, 0, CITY_MAX_CONNECTION_DISTANCE_BETWEEN_CITIES + 1, 0);

        WorldGenerator testee = new WorldGenerator(random);

        World world = testee.generate(2);

        City[] cities = world.getCities().toArray(new City[0]);
        Assert.assertEquals(2, world.getCities().size());
        Assert.assertFalse(world.getRoutes().hasEdgeConnecting(cities[0], cities[1]));
    }

    @Test
    public void twoCitiesCreateTwoConnections() {

        when(random.nextInt(GRID_SIZE + 1)).thenReturn(0, 0, CITY_MIN_DISTANCE_BETWEEN_CITIES + 1, 0);

        WorldGenerator testee = new WorldGenerator(random);

        World world = testee.generate(2);

        City[] cities = world.getCities().toArray(new City[0]);
        Assert.assertTrue(world.getRoutes().hasEdgeConnecting(cities[0], cities[1]));
        Assert.assertTrue(world.getRoutes().hasEdgeConnecting(cities[1], cities[0]));
    }
}