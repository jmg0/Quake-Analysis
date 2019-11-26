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
    private ArrayList<Earthquake> filteredEarthquakeList;

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

    /**
     * Takes a Filter parameter and returns ArrayList of Earthquake objects that satisfy the Filter
     * @param filter
     * @return
     */
    public ArrayList<Earthquake> filter(Filter filter) {
        filteredEarthquakeList = new ArrayList<>();
        for( Earthquake e : earthquakes ) {
            if(filter.satisfies(e)) {
                filteredEarthquakeList.add(e);
            }
        }
        return filteredEarthquakeList;
    }

    public void printEarthquakes(ArrayList<Earthquake> earthquakes) {
        for(Earthquake earthquake: earthquakes) {
            System.out.println(earthquake.quakeInfo());
        }
    }

    public void printEarthquakeInfo() {
        printEarthquakeCollectionInfo();
        printEarthquakes(earthquakes);
    }

    public void printEarthquakeCollectionInfo() {
        System.out.println("This " + getTitle() + " list comes from " + getUrl() + " and contains " + getNumEarthquakes() + " earthquakes.");
    }

    /**
     * Requires filter() has been called
     */
    public void printFilteredEarthquakeInfo() {
        System.out.println("This " + getTitle() + "list has been filtered and contains " + filteredEarthquakeList.size() + " earthquakes.");
        printEarthquakes(filteredEarthquakeList);
    }


}
