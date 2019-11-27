package com.jmg0.quakeanalysis;

public class MagnitudeFilter implements Filter {
    private double minMag, maxMag;

    public MagnitudeFilter(double minMag, double maxMag) {
        this.minMag = minMag;
        this.maxMag = maxMag;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        if(earthquake.getMag() >= minMag && earthquake.getMag() <= maxMag) {
            return true;
        }

        return false;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with magnitude between " + minMag + " and " + maxMag + " (inclusive)";
    }


}
