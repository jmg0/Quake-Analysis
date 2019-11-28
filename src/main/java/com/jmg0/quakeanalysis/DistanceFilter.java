package com.jmg0.quakeanalysis;

public class DistanceFilter implements Filter {
    private Location location;
    private double maxDistance;
    private String name;

    public DistanceFilter(Location location, double maxDistance, String name) {
        this.location = location;
        this.maxDistance = maxDistance;
        this.name = name;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return location.distanceTo(earthquake.getLocation()) <= maxDistance;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes within " + maxDistance + " kilometers of location [" + location.getLatitude() + ", " + location.getLongitude() + "]";
    }

    @Override
    public String getName() {
        return name;
    }
}
