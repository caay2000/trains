package com.github.caay2000.trains.model.world;

import com.github.caay2000.trains.model.Position;
import com.github.caay2000.trains.model.world.WorldObject;
import org.junit.Test;
import lombok.EqualsAndHashCode;
import nl.jqno.equalsverifier.EqualsVerifier;

public class WorldObjectTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(WorldObject.class)
                .withRedefinedSubclass(WorldObjectTestImpl.class)
                .verify();
    }

    @EqualsAndHashCode
    private class WorldObjectTestImpl extends WorldObject {

        protected WorldObjectTestImpl(Position position) {
            super(position);
        }

        @Override
        public void update() {

        }
    }
}