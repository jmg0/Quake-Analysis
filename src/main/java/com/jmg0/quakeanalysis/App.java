package com.jmg0.quakeanalysis;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        EarthquakeCollection earthquakeCollection = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-01-02");
        earthquakeCollection.printEarthquakeInfo();

    }

}
