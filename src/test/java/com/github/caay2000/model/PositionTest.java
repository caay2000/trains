package com.github.caay2000.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

import static com.github.caay2000.model.Constants.POSITION_DELTA;

public class PositionTest {

    private static final double ONE_DISTANCE = 1d;
    private static final double DIAGONAL_DISTANCE = 1.41d;

    @Test
    public void distanceToSamePosition() {
        Position a = new Position(0, 0);
        Position b = new Position(0, 0);

        assertDistance(0d, a.distanceTo(b));
    }

    @Test
    public void distanceToHorizontal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 0);

        assertDistance(ONE_DISTANCE, a.distanceTo(b));
    }

    @Test
    public void distanceToVertical() {
        Position a = new Position(0, 0);
        Position b = new Position(0, 1);

        assertDistance(ONE_DISTANCE, a.distanceTo(b));
    }

    @Test
    public void distanceToDiagonal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 1);

        assertDistance(DIAGONAL_DISTANCE, a.distanceTo(b));
    }

    @Test
    public void distanceToMultiDiagonal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 2);

        assertDistance(2.23d, a.distanceTo(b));
    }

    @Test
    public void distanceToNegativeDiagonal() {
        Position a = new Position(-1, -1);
        Position b = new Position(-2, -2);

        assertDistance(DIAGONAL_DISTANCE, a.distanceTo(b));
    }

    @Test
    public void noMovement() {
        Position start = new Position(0, 0);
        Position moved = start.move(0, 0);

        Assert.assertEquals(start, moved);
    }

    @Test
    public void someMovement() {
        Position start = new Position(0, 0);
        Position moved = start.move(1, 1);

        Assert.assertNotEquals(start, moved);
        assertDistance(DIAGONAL_DISTANCE, start.distanceTo(moved));
    }

    @Test
    public void negativeMovement() {
        Position start = new Position(-1, -1);
        Position moved = start.move(-1, -1);

        Assert.assertNotEquals(start, moved);
        assertDistance(DIAGONAL_DISTANCE, start.distanceTo(moved));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Position.class).verify();
    }

    private static void assertDistance(double expected, double actual) {
        Assert.assertEquals(expected, actual, Constants.getDouble(POSITION_DELTA));
    }
}