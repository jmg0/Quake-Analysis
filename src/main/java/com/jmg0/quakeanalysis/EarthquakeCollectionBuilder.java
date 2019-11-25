package com.jmg0.quakeanalysis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class EarthquakeCollectionBuilder {

    /**
     * Requires url be a valid url from https://earthquake.usgs.gov
     * @param url
     * @return
     */
    public static EarthquakeCollection build(String url) {
        EarthquakeCollection earthquakeCollection = new EarthquakeCollection();
        EarthquakeJSONStringArranger arranger = new EarthquakeJSONStringArranger();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String[] JSONStrings = arranger.JSONStringArranger(ReadFileFromURL.readFileFromURLIntoString(url));

        try {
            earthquakeCollection = objectMapper.readValue(JSONStrings[0], EarthquakeCollection.class);
            earthquakeCollection.setEarthquakesFromJSONString(JSONStrings[1]);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return earthquakeCollection;
    }


}
