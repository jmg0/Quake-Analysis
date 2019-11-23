package com.jmg0.quakeanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public abstract class ReadFileFromURL {

    /**
     * Requires urlString be a valid url from https://earthquake.usgs.gov
     * @param urlString
     */
    public static BufferedReader openFileFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection urlConnected = url.openConnection();
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(urlConnected.getInputStream()));
            return urlReader;
        }
        catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Requires urlReader be a functioning BufferedReader
     * @param urlReader
     * @return
     */
    public static String readFileIntoString(BufferedReader urlReader) {
        String nextLine;
        StringBuilder JSONString = new StringBuilder();
        try {
            while((nextLine = urlReader.readLine()) != null) {
                JSONString.append(nextLine);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return JSONString.toString();
    }

}
