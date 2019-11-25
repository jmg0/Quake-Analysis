package com.jmg0.quakeanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.InputStream;
import java.util.Map;

public class Earthquake {
    private double mag;
    private String place;
    private long time;
    private String id;
    private String title;

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

    public String getPlace() {
        return place;
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

    public String quakeInfo() {
        return (getTitle() + ": a " + getMag() + " magnitude earthquake occurred in " + getPlace() + " at " + getTime());
    }

}
