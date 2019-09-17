package com.github.caay2000.trains.model.world;

import com.github.caay2000.trains.model.Position;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(exclude = {"name", "population"}, callSuper = true)
public final class City extends WorldObject {

    private final String name;
    private int population;

    public City(String name, Position position, int population) {
        super(position);
        this.name = name;
        this.population = population;
    }

    @Override
    public void update() {

    }

    public static final class Builder {
        protected Position position;
        private String name;
        private int population;

        private Builder() {
        }

        public static Builder aCity() {
            return new Builder();
        }

        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder population(int population) {
            this.population = population;
            return this;
        }

        public City build() {
            return new City(name, position, population);
        }
    }
}
