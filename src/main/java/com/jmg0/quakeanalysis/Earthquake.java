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
        if(doubleOrInt(mag)) {
            this.mag = Double.parseDouble(mag);
        }
        else {
            this.mag = Integer.parseInt(mag);
        }
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

    /**
     * Requires: numericString must be a String that can be converted either to double or int
     * @param numericString
     * @return
     */
    private boolean doubleOrInt(String numericString) {
        try {
            Double.parseDouble(numericString);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @JsonProperty("properties")
    private void unpackProperties(Map<String, Object> properties) {
        Object magObject = properties.get("mag");
        String magString = (String) magObject;
        if(doubleOrInt(magString)) {
            this.mag = (double) magObject;
        }
        else {
            this.mag = (int) magObject;
        }
        this.place = (String) properties.get("place");
        this.time = (Long) properties.get("time");
        this.title = (String) properties.get("title");
    }

}
