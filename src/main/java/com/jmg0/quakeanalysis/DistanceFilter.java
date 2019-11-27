package com.jmg0.quakeanalysis;

public class DistanceFilter implements Filter {
    private Location location;
    private double maxDistance;

    public DistanceFilter(Location location, double maxDistance) {
        this.location = location;
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        if(location.distanceTo(earthquake.getLocation()) <= maxDistance) {
            return true;
        }
        return false;
    }

    @Override
    public String filterDescription() {
        return null;
    }
}
