package com.github.caay2000.trains.model;

import lombok.EqualsAndHashCode;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class WorldObjectTest {

    @EqualsAndHashCode
    private class WorldObjectTestImpl extends WorldObject {

        protected WorldObjectTestImpl(Position position) {
            super(position);
        }

        @Override
        public void update() {

        }
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(WorldObject.class)
                .withRedefinedSubclass(WorldObjectTestImpl.class)
                .verify();
    }

}