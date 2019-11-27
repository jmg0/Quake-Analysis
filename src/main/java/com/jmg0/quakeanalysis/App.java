package com.jmg0.quakeanalysis;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        // 84 quakes + MinMagnitude filter
        //EarthquakeCollection earthquakeCollection = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-01-02");
        //earthquakeCollection.printEarthquakeInfo();

        //System.out.println();

        //MinMagnitude minMagFilter = new MinMagnitude(4.9);
        //earthquakeCollection.filter(minMagFilter);
        //earthquakeCollection.printFilteredEarthquakeInfo();

        // 5513 quakes
        //EarthquakeCollection earthquakeCollection2 = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-03-01");
        //earthquakeCollection2.printEarthquakeInfo();

        // 13749 quakes
        //EarthquakeCollection earthquakeCollection3 = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-06-01");
        //earthquakeCollection3.printEarthquakeInfo();

        // 84 quakes with builder2
        EarthquakeCollection earthquakeCollection4 = EarthquakeCollectionBuilder2.build2("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-01-02");
        earthquakeCollection4.printEarthquakeInfo();


    }

}
