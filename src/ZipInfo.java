/********************************************************************************************
 * Nicholas Mel
 * Description: ZipInfo represents a combination of city, state, and zip code
 ********************************************************************************************/

import java.io.*;

public class ZipInfo {

    private String city, state;
    private int zipcode;

    public ZipInfo(String city1, String state1, int zip1) {
        zipcode = zip1;
        city = city1;
        state = state1;
    }

    //Accessor method for city
    public String getCity() {
        return city;
    }

    //Accessor method for state
    public String getState() {
        return state;
    }

    //Accessor method for zipcode
    public int getZipcode() {
        return zipcode;
    }

    //The toString method return a string containing
    //the city, state, and zip code
    public String toString() {
        return (city + " in " + state + " with zipcode of " + zipcode + "\n");
    }
}

