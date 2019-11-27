package com.jmg0.quakeanalysis;

public class MagnitudeFilter implements Filter {
    private double minMag, maxMag;

    public MagnitudeFilter(double minMag, double maxMag) {
        this.minMag = minMag;
        this.maxMag = maxMag;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getMag() >= minMag && earthquake.getMag() <= maxMag;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with magnitude between " + minMag + " and " + maxMag + " (inclusive)";
    }


}
