package hk.edu.hkbu.comp.hkbumapnavigated;

import java.util.ArrayList;
import java.util.List;

public class LocationCreator {
    public static HKBULocation[] getLocations() {
        List<HKBULocation> locations = new ArrayList<>();

        locations.add(new HKBULocation("Academic Administration Building", "AAB", "aab.jpg"));
        locations.add(new HKBULocation("Student Residence Hall South", "SRHS", "srh_south.jpg"));

        HKBULocation[] list = new HKBULocation[locations.size()];
        list = locations.toArray(list);
        return list;
    }
}
