package com.github.caay2000.trains.model;

import org.junit.Assert;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class CityTest {

    private static final Position ANY_POSITION = new Position(0, 0);
    private static final Position ANOTHER_POSITION = new Position(1, 1);

    @Test
    public void testEqualsSameCity() {
        City oneCity = new City("oneCity", ANY_POSITION, 0);
        City cloneCity = new City("cloneCity", ANY_POSITION, 10);

        Assert.assertEquals(oneCity, cloneCity);
    }

    @Test
    public void testEqualsDifferentCity() {
        City oneCity = new City("oneCity", ANY_POSITION, 0);
        City anotherCity = new City("oneCity", ANOTHER_POSITION, 0);

        Assert.assertNotEquals(oneCity, anotherCity);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(City.class)
                .withIgnoredFields("name", "population")
                .withRedefinedSuperclass()
                .verify();
    }
}