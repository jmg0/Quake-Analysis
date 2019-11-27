package com.jmg0.quakeanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Earthquake {
    private double mag;
    private String place;
    private long time;
    private String id;
    private String title;
    private double latitude, longitude, depth;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMag(String mag) {
        this.mag = Double.parseDouble(mag);
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public double getMag() {
        return mag;
    }

    public long getTime() {
        return time;
    }

    public Date getDateFromTime() {
        return new Date(getTime());
    }

    public String getPlace() {
        return place;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    @JsonProperty("properties")
    private void unpackProperties(Map<String, Object> properties) {
        try {
            this.mag = (double) properties.get("mag");
        }
        catch (Exception e) {
            this.mag = (int) properties.get("mag");
        }
        this.place = (String) properties.get("place");
        this.time = (Long) properties.get("time");
        this.title = (String) properties.get("title");
    }

    @JsonProperty("geometry")
    private void unpackGeometry(Map<String, Object> geometry) {
        double[] coordinates = (double[]) geometry.get("coordinates");
        
        this.longitude = (double) coordinates[0];
        this.latitude = (double) coordinates[1];
        this.depth = (double) coordinates[2];
    }

    public String quakeInfo() {
        return (getTitle() + ": a " + getMag() + " magnitude earthquake occurred " + getDateFromTime() + " at " + getPlace() + ", coordinates[" + getLatitude() + ", " + getLongitude() + "]");
    }

}
