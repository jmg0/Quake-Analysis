package com.jmg0.quakeanalysis;

import java.lang.Math;


public class Location {
    private double latitude, longitude, latInRads, longInRads;
    private static final double earthMeanRadiusInKM = 6371;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.latInRads = Math.toRadians(this.latitude);
        this.longInRads = Math.toRadians(this.longitude);
    }

    private double haversineComputation(Location location) {
        double sinSquaredLatitudeTerm = Math.sin( Math.abs(this.latInRads-location.getLatInRads()) / 2 ) * Math.sin( Math.abs(this.latInRads-location.getLatInRads()) / 2 );
        double sinSquaredLongitudeTerm = Math.sin( Math.abs(this.longInRads-location.getLongInRads()) / 2 ) * Math.sin( Math.abs(this.longInRads-location.getLongInRads()) / 2 );
        double a = sinSquaredLatitudeTerm + ( Math.cos(this.latInRads) * Math.cos(location.getLongInRads()) * sinSquaredLongitudeTerm );

        return 2 * Math.atan2( Math.sqrt(a), Math.sqrt(1-a));
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

    public double getLatInRads() {
        return latInRads;
    }

    public void setLatInRads(double latInRads) {
        this.latInRads = latInRads;
    }

    public double getLongInRads() {
        return longInRads;
    }

    public void setLongInRads(double longInRads) {
        this.longInRads = longInRads;
    }
}
