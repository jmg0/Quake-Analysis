package com.jmg0.quakeanalysis;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        // 84 quakes
        //EarthquakeCollection earthquakeCollection = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-01-02");
        //earthquakeCollection.printEarthquakeInfo();

        // 5513 quakes
        //EarthquakeCollection earthquakeCollection2 = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-03-01");
        //earthquakeCollection2.printEarthquakeInfo();

        // 13749 quakes
        //EarthquakeCollection earthquakeCollection3 = EarthquakeCollectionBuilder.build("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=2&starttime=2019-01-01&endtime=2019-06-01");
        //earthquakeCollection3.printEarthquakeInfo();


        long time = System.currentTimeMillis();
        //long nanoTime = System.nanoTime();
        System.out.println(time);
        //System.out.println(nanoTime);

        Date date = new Date(1559346705510L);
        System.out.println(date);


    }

}
