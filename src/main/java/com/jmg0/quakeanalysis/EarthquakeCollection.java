package com.jmg0.quakeanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;

public class EarthquakeCollection {
    private String title, url;
    private int numEarthquakes;
    private ArrayList<Earthquake> earthquakes;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumEarthquakes(int numEarthquakes) {
        this.numEarthquakes = numEarthquakes;
    }

    public void setEarthquakes(ArrayList<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    /**
     * Requires JSONString be array of earthquake objects from https://earthquake.usgs.gov
     * @param JSONString
     */
    public void setEarthquakesFromJSONString(String JSONString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.earthquakes = objectMapper.readValue(JSONString, new TypeReference<ArrayList<Earthquake>>(){});
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getNumEarthquakes() {
        return numEarthquakes;
    }

    public ArrayList<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    @JsonProperty("metadata")
    private void unpackMetadata(Map<String, Object> metadata) {
        this.title = (String) metadata.get("title");
        this.url = (String) metadata.get("url");
        this.numEarthquakes = (int) metadata.get("count");
    }

    public void printEarthquakeInfo() {
        printEarthquakeCollectionInfo();
        for(Earthquake earthquake : earthquakes) {
            System.out.println(earthquake.quakeInfo());
        }
    }

    public void printEarthquakeCollectionInfo() {
        System.out.println("This " + getTitle() + " list comes from " + getUrl() + " and contains " + getNumEarthquakes() + " earthquakes.");
    }


}
