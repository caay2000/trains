package com.github.caay2000.trains.model;

import java.util.Date;

public class Simulation {

    private static final long ZERO_MILLI_SECONDS = 0;
    private final double simulationFactor;
    private long realEpoch;
    private long simulationEpoch;

    public Simulation(double simulationFactor) {
        this.simulationEpoch = new Date().getTime();
        this.realEpoch = this.simulationEpoch;
        this.simulationFactor = simulationFactor;
    }

    public void updateSimulation(int secondsElapsed) {

        long actualEpoch = new Date().getTime();
        long realTimeElapsed = actualEpoch - realEpoch;

        this.simulationEpoch += secondsElapsed * 1000;
        try {
            long sleepMillis = (int) Math.floor(secondsElapsed * this.simulationFactor);
            Thread.sleep(Math.max(ZERO_MILLI_SECONDS, sleepMillis - realTimeElapsed));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TrainsException("error simulating time", e);
        }
        this.realEpoch = new Date().getTime();
    }

    public long getSimulationTime() {
        return this.simulationEpoch;
    }
}
