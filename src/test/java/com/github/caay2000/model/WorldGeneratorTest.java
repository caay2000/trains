package com.github.caay2000.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorldGeneratorTest {

    private static final Position POSITION_START = new Position(0, 0);
    private static final Position POSITION_SHORT = new Position(Grid.MINIMUM_DISTANCE_BETWEEN_CITIES - 1, 0);
    private static final Position POSITION_OK = new Position(Grid.MINIMUM_DISTANCE_BETWEEN_CITIES + 1, 0);
    private static final Position POSITION_LONG = new Position(Grid.MAXIMUM_CONNECTION_DISTANCE_BETWEEN_CITIES + 1, 0);

    @Mock
    private Grid grid;

    @Test
    public void shortDistanceIsNotSuitable() {

        when(grid.getRandomPosition()).thenReturn(POSITION_START, POSITION_SHORT);

        WorldGenerator testee = new WorldGenerator(grid);

        World world = testee.generate(2);
        Assert.assertEquals(1, world.getCities().size());
    }


    @Test
    public void twoCitiesCreated() {

        when(grid.getRandomPosition()).thenReturn(POSITION_START, POSITION_OK);

        WorldGenerator testee = new WorldGenerator(grid);

        World world = testee.generate(2);
        Assert.assertEquals(2, world.getCities().size());
    }

    @Test
    public void twoCitiesCreatedButNotConnectedWhenDistanceIsTooLong() {

        when(grid.getRandomPosition()).thenReturn(POSITION_START, POSITION_LONG);

        WorldGenerator testee = new WorldGenerator(grid);

        World world = testee.generate(2);

        City[] cities = world.getCities().toArray(new City[0]);
        Assert.assertEquals(2, world.getCities().size());
        Assert.assertFalse(world.getRoutes().hasEdgeConnecting(cities[0], cities[1]));
    }

    @Test
    public void twoCitiesCreateTwoConnections() {

        when(grid.getRandomPosition()).thenReturn(POSITION_START, POSITION_OK);

        WorldGenerator testee = new WorldGenerator(grid);

        World world = testee.generate(2);

        City[] cities = world.getCities().toArray(new City[0]);
        Assert.assertTrue(world.getRoutes().hasEdgeConnecting(cities[0], cities[1]));
        Assert.assertTrue(world.getRoutes().hasEdgeConnecting(cities[1], cities[0]));
    }

}