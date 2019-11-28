package com.jmg0.quakeanalysis;

public class MinMagnitude implements Filter {
    private double minMagnitude;
    private String name;

    public MinMagnitude(double minMagnitude, String name) {
        this.minMagnitude = minMagnitude;
        this.name = name;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getMag() >= minMagnitude;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with magnitude greater than or equal to " + minMagnitude;
    }

    @Override
    public String getName() {
        return name;
    }
}
