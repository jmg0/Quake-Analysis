package com.jmg0.quakeanalysis;

public class EarthquakeJSONStringArranger {

    /**
     * Requires earthquakeDataJSON be a JSON String of earthquake data in format used on https://earthquake.usgs.gov
     * Returns array of size 2 with element 0 metadata for EarthquakeCollection and element 1 earthquake
     * feature data for Earthquake(s)
     * @param earthquakeDataJSON
     * @return
     */
    public String[] stringArranger(String earthquakeDataJSON) {
        String[] JSONStrings = earthquakeDataJSON.split(",\"features\":");
        String metadata = JSONStrings[0];
        String earthquakesAsFeatures = JSONStrings[1].split(",\"bbox")[0];

        

        return new String[2];
    }

}
