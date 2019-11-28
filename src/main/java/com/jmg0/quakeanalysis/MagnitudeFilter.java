package com.jmg0.quakeanalysis;

public class MagnitudeFilter implements Filter {
    private double minMag, maxMag;
    private String name;

    public MagnitudeFilter(double minMag, double maxMag, String name) {
        this.minMag = minMag;
        this.maxMag = maxMag;
        this.name = name;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getMag() >= minMag && earthquake.getMag() <= maxMag;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with magnitude between " + minMag + " and " + maxMag + " (inclusive)";
    }

    @Override
    public String getName() {
        return name;
    }
}
