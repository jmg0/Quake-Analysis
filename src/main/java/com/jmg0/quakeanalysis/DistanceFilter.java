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
        return location.distanceTo(earthquake.getLocation()) <= maxDistance;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes within " + maxDistance + " kilometers of location [" + location.getLatitude() + ", " + location.getLongitude() + "]";
    }
}
