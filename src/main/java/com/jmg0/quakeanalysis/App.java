package com.jmg0.quakeanalysis;

import java.util.ArrayList;
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
        System.out.println();

        CompositeFilter filter = new CompositeFilter();
        filter.addFilter(new MinMagnitude(3.1, "min magnitude 3.1"));
        filter.addFilter(new DistanceFilter(new Location(36.1314, -95.9372), 10000, "Distance 10,000km from Tulsa, OK"));
        filter.addFilter(new PhraseFilter("Alaska", "in Alaska"));
        //filter.addFilter(new DepthFilter(30, 100, "Depth 30-100km));

        ArrayList<Earthquake> filteredList = earthquakeCollection4.filter(filter);
        earthquakeCollection4.printFilteredEarthquakeInfo();
        System.out.println();

        for (Earthquake e : filteredList) {
            System.out.println(e.getLocation().printLocation() + " " + e.getLocation().distanceTo(new Location(36.1314, -95.9372)));
        }

//
//        MinMagnitude minMagFilter = new MinMagnitude(4.9);
//        earthquakeCollection4.filter(minMagFilter);
//        earthquakeCollection4.printFilteredEarthquakeInfo();

//        Location l1 = new Location(-14.95, 167.2922);
//        Location l2 = new Location(60.6497, -147.438);
//
//        System.out.println(l1.distanceTo(l2));
//        System.out.println(l2.distanceTo(l1));
//
//        Location l3 = new Location(-17, 168);
//        Location l4 = new Location(21, -157);
//
//        System.out.println(l3.distanceTo(l4));



    }

}
