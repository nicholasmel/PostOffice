/*******************************************************************************************
 * Nicholas Mel
 * Description: The PostOffice class has a list of ZipInfo object
 * that can be organized at the post office. The post office will be a fully encapsulated object.
********************************************************************************************/

import java.util.*;

public class PostOffice {

    private ArrayList<ZipInfo> zipcodeList;
    private ZipInfo name;

    public PostOffice() {
        zipcodeList = new ArrayList<ZipInfo>();
    }

    //Search for a ZipInfo object by zipcode and return the index of the object if found. Return -1 if not found.
    //The parameter is the zipcode of a ZipInfo object.
    public int zipcodeExists(int zipcode) {
        for (int i = 0; i < zipcodeList.size(); i++) {
            if (zipcode == ((ZipInfo) zipcodeList.get(i)).getZipcode()) {
                return i;
            }
        }
        return -1;
    }

    //Search for a ZipInfo object by city and state and return the index of the object if found. Return -1 if not found.
    //The parameters are city and state of a ZipInfo object.
    public int cityStateExists(String city, String state) {
        for (int i = 0; i < zipcodeList.size(); i++) {
            if (((ZipInfo)zipcodeList.get(i)).getCity().equals(city) && ((ZipInfo)zipcodeList.get(i)).getState().equals(state)) {
                return i;
            }
        }
        return -1;
    }

    //Add a ZipInfo object to the zipcode list. Return true if such object was added successfully.
    //Return false if an object with the same zipcode already exists (the new object is not added).
    public boolean addZipInfo(String city, String state, int zipcode) {
        name = new ZipInfo(city, state, zipcode);
        if (zipcodeExists(zipcode) == -1) {
            zipcodeList.add(name);
            return true;
        }
        return false;
    }

    //Remove a ZipInfo object from the zipcode list. Return true if the object was removed successfully.
    //Return false if the object with the given zipcode does not exist.
    public boolean removeZipcode(int zipcode) {
        for (int i = 0; i < zipcodeList.size(); i++) {
            if (zipcode == ((ZipInfo) zipcodeList.get(i)).getZipcode()) {
                zipcodeList.remove(name);
                return true;
            }
        }
        return false;
    }

    //Remove a ZipInfo object from the zipcode list. Return true if the object was removed successfully.
    //Return false if the object with the given city and state does not exist.
    public boolean removeCityState(String city, String state) {
        for (int i = 0; i < zipcodeList.size(); i++) {
            if (((ZipInfo)zipcodeList.get(i)).getCity().equals(city) && ((ZipInfo)zipcodeList.get(i)).getState().equals(state)) {
                zipcodeList.remove(name);
                return true;
            }
        }
        return false;
    }

    //Sort the list of ZipInfo objects by zipcode.
    //This method calls the sort method defined in the Sorts class, using an object of ZipcodeComparator class as its second parameter.
    public void sortByZipcode() {
        ZipcodeComparator compareZip = new ZipcodeComparator();
        Sorts.sort(zipcodeList, compareZip);
    }
    
    public void sortByCityState() {
        CityStateComparator compareCs = new CityStateComparator();
        Sorts.sort(zipcodeList, compareCs);
    }

    public String listZipcode() {
        String output = "\nno zipcode\n\n";
        String zipList = new String();
        int zip = 0;
        if (zipcodeList.isEmpty()) {
            return output;
        } else {
            for (int i = 0; i < zipcodeList.size(); i++) {
                zip = zipcodeList.get(i).getZipcode();
                zipList += Integer.toString(zip) + "\n";
            }
            return zipList;
        }
    }

    public void closePostOffice() {
        //Closes the post office by making the list empty.
        zipcodeList.clear();
    }
}
