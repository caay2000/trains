package com.github.caay2000;

import com.github.caay2000.model.Position;
import org.junit.Assert;
import org.junit.Test;

import static com.github.caay2000.model.Position.POSITION_DELTA;

public class PositionTest {

    @Test
    public void distanceToSamePosition() {
        Position a = new Position(0, 0);
        Position b = new Position(0, 0);

        Assert.assertEquals(0d, a.distanceTo(b), 0d);
    }

    @Test
    public void distanceToHorizontal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 0);

        Assert.assertEquals(1d, a.distanceTo(b), 0d);
    }

    @Test
    public void distanceToVertical() {
        Position a = new Position(0, 0);
        Position b = new Position(0, 1);

        Assert.assertEquals(1d, a.distanceTo(b), 0d);
    }

    @Test
    public void distanceToDiagonal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 1);

        Assert.assertEquals(1.41d, a.distanceTo(b), POSITION_DELTA);
    }

    @Test
    public void distanceToMultiDiagonal() {
        Position a = new Position(0, 0);
        Position b = new Position(1, 2);

        Assert.assertEquals(2.23d, a.distanceTo(b), POSITION_DELTA);
    }

    @Test
    public void distanceToNegativeDiagonal() {
        Position a = new Position(-1, -1);
        Position b = new Position(-2, -2);

        Assert.assertEquals(1.41d, a.distanceTo(b), POSITION_DELTA);
    }

}