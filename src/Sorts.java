/********************************************************************************************
 * Nicholas Mel
 * Description: Sorts the ArrayList and compare zipcode, city, state
 ********************************************************************************************/

import java.util.*;

public class Sorts {

    public static void sort(ArrayList<ZipInfo> zipList, Comparator<ZipInfo> comparison) {
        for (int i = 1; i < zipList.size(); i++) {
            while (i < zipList.size() - 1 && comparison.compare(zipList.get(i + 1), zipList.get(i)) < 0) {
                zipList.set(i, zipList.set(i + 1, zipList.get(i)));
                i++;
            }
        }
    }
}
