package com.jmg0.quakeanalysis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class EarthquakeCollectionBuilder2 {

    /**
     * Requires url be a valid url from https://earthquake.usgs.gov
     * @param url
     * @return
     */
    public static EarthquakeCollection build2(String url) {
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        EarthquakeCollection earthquakeCollection = new EarthquakeCollection();
        EarthquakeJSONStringArranger arranger = new EarthquakeJSONStringArranger();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String[] JSONStrings = arranger.JSONStringArranger(ReadFileFromURL.readFileFromURLIntoString(url));

        try {
            earthquakeCollection = objectMapper.readValue(JSONStrings[0], EarthquakeCollection.class);
            earthquakeCollection.setEarthquakesFromJSONString(JSONStrings[1]);

            int counter = 0;
            JsonNode featuresArray = objectMapper.readTree(JSONStrings[1]);
            for(JsonNode earthquakeNode : featuresArray) {
                JsonNode geometryNode = earthquakeNode.path("geometry");
                JsonNode coordinatesNode = geometryNode.path("coordinates");
                if(coordinatesNode.isArray()) {
                    double[] coordinates = new double[3];
                    int i = 0;
                    for(JsonNode coords : coordinatesNode) {
                        coordinates[i] = coords.asDouble();
                        i++;
                    }
                    earthquakeCollection.getEarthquakes().get(counter).setCoordinates(coordinates);
                }
                counter++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return earthquakeCollection;
    }

}
