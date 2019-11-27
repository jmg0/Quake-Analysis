package com.jmg0.quakeanalysis;

public class MinMagnitude implements Filter {
    private double minMagnitude;

    public MinMagnitude(double minMagnitude) {
        this.minMagnitude = minMagnitude;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getMag() >= minMagnitude;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with magnitude greater than or equal to " + minMagnitude;
    }
}
