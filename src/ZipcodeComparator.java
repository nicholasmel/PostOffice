/********************************************************************************************
 * Nicholas Mel
 * Description: ZipcodeComparator compares zipcode objects
 ********************************************************************************************/

import java.util.*;

public class ZipcodeComparator implements Comparator<ZipInfo> {

    public int compare(ZipInfo zip1, ZipInfo zip2) {
        return zip1.getZipcode() - zip2.getZipcode();
    }
}
	
