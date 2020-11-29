/*************************************************************************************************
 * Nicholas Mel
 * Description: CityStateComparator compares city and state objects.
 ********************************************************************************************/

import java.util.*;

public class CityStateComparator implements Comparator<ZipInfo> {

    public int compare(ZipInfo city1, ZipInfo state1) {
        return (city1.getCity()).compareTo(state1.getState());
    }
}
