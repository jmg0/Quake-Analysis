package com.jmg0.quakeanalysis;

import java.lang.Math;


public class Location {
    private double latitude, longitude;
    private static final double earthMeanRadiusInKM = 6371;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private double haversineComputation(Location location) {
        double phi1 = Math.toRadians(latitude);
        double phi2 = Math.toRadians(location.getLatitude());
        double deltaPhi = Math.toRadians(location.getLatitude() - latitude);
        double deltaLambda = Math.toRadians(location.getLongitude() - longitude);

        double a = Math.sin(deltaPhi/2) * Math.sin(deltaPhi/2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda/2) * Math.sin(deltaLambda/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return c;
    }

    public double distance(Location location) {
        double c = haversineComputation(location);
        return c * earthMeanRadiusInKM;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
