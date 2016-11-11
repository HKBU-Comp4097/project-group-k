package hk.edu.hkbu.comp.hkbumapnavigated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationCreator {

    private HKBULocation[] locations;
    private static volatile LocationCreator locationCreator = null;

    private LocationCreator() {
        initLocations();
    }

    private void initLocations() {
        List<HKBULocation> list = new ArrayList<>();

        list.add(new HKBULocation("Music Rehearsal Hall", "MRH", "stb_ash_mrh", 22.341416, 114.179505));
        list.add(new HKBULocation("Au Shue Hung Terrace Garden", "ASH", "stb_ash_mrh", 22.341437, 114.180049));
        list.add(new HKBULocation("Sing Tao Building", "STB", "stb_ash_mrh", 22.341337, 114.180272));
        list.add(new HKBULocation("Academic Community Hall", "ACH", "ach_and_lmc", 22.341195, 114.179945));
        list.add(new HKBULocation("Lui Ming Choi Centre", "LMC", "ach_and_lmc", 22.341153, 114.179569));
        list.add(new HKBULocation("Christian Education Centre", "CEC", "cec", 22.341148, 114.180276));
        list.add(new HKBULocation("Oen Hall Main", "OEM", "oem", 22.340864, 114.179909));
        list.add(new HKBULocation("Oen Hall West", "OEW", "oew", 22.340831, 114.180301));
        list.add(new HKBULocation("Oen Hall East", "OEE", "oee", 22.340755, 114.179614));
        list.add(new HKBULocation("Cha Chi-ming Science Tower", "SCT", "sct", 22.340573, 114.179957));
        list.add(new HKBULocation("Yeung Shui Sang Building", "YSS", "yss", 22.340407, 114.180359));
        list.add(new HKBULocation("Sir Run Run Shaw Building", "RRS", "rrs", 22.340223, 114.179690));
        list.add(new HKBULocation("Fong Shu Chuen Library", "FSC", "fsc", 22.340233, 114.180170));
        list.add(new HKBULocation("Man Lung Garden", "MLG", "mlg", 22.339805, 114.180740));
        list.add(new HKBULocation("Franki Centre", "FC", "fc", 22.339319, 114.180743));
        list.add(new HKBULocation("Wai Hang Sports Centre", "WHS", "whs", 22.339650, 114.181656));
        list.add(new HKBULocation("Shaw Tower", "SWT", "swt", 22.338762, 114.182015));
        list.add(new HKBULocation("Au Shue Hung Memorial Library", "AML", "aml", 22.338310, 114.181956));
        list.add(new HKBULocation("Joint Sports Centre", "JSC", "jsc", 22.337732, 114.182251));
        list.add(new HKBULocation("Wing Lung Bank Building", "WLB", "wlb", 22.337859, 114.181779));
        list.add(new HKBULocation("Lam Woo International Conference Centre", "LWC", "lwc", 22.337396, 114.181951));
        list.add(new HKBULocation("David C. Lam Building", "DLB", "dlb", 22.337304, 114.181742));
        list.add(new HKBULocation("Madam Kwok Chung Bo Fun Sports and Cultural Centre", "SCC", "scc", 22.337120, 114.182211));
        list.add(new HKBULocation("Academic and Administration Building", "AAB", "aab", 22.336570, 114.182019));
        list.add(new HKBULocation("Dr. Ng Tor Tai International House", "NTT", "ntt", 22.336367, 114.181791));
        list.add(new HKBULocation("Jockey Club Academic Community Centre", "ACC", "acc", 22.336367, 114.181791));
        list.add(new HKBULocation("Madam Chan Wu Wan Kwai School of Continuing Education", "SCE", "sce", 22.336074, 114.182732));
        list.add(new HKBULocation("Jockey Club School of Chinese Medicine Building", "SCM", "scm", 22.335682, 114.182622));
        list.add(new HKBULocation("Student Residence Halls North", "SRHN", "srh_north", 22.335387, 114.182539));
        list.add(new HKBULocation("Student Residence Halls South", "SRHS", "srh_south", 22.335050, 114.182518));
        list.add(new HKBULocation("Communication and Visual Arts Building", "CVA", "cva", 22.334251, 114.182440));

        Collections.sort(list);

        locations = new HKBULocation[list.size()];
        locations = list.toArray(locations);
    }

    // Thread-safe Singleton
    public static HKBULocation[] getLocations() {
        if (locationCreator == null) {
            synchronized (LocationCreator.class) {
                if (locationCreator == null) {
                    locationCreator = new LocationCreator();
                }
            }
        }
        return locationCreator.locations;
    }
}
