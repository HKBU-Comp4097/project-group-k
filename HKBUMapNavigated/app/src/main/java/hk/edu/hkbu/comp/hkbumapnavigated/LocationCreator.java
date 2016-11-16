package hk.edu.hkbu.comp.hkbumapnavigated;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocationCreator {

    private HKBULocation[] locations;
    private ArrayList<HKBUSimpleLocation> simpleLocations;
    private static volatile LocationCreator locationCreator = null;
    private static Context context;

    private LocationCreator(String lang) {
        initLocations(lang);
    }

    public static void setContext(Context c) {
        context = c;
    }

    private void initLocations(String lang) {
        List<HKBULocation> list = new ArrayList<>();

        HKBUDepartment chinese = new HKBUDepartment(context.getString(R.string.chinese), "http://chi.hkbu.edu.hk", "chi@hkbu.edu.hk", "(852) 3411 7891");
        HKBUDepartment english = new HKBUDepartment(context.getString(R.string.english), "http://eng.hkbu.edu.hk", "eng@hkbu.edu.hk", "(852) 3411 7171");
        HKBUDepartment language = new HKBUDepartment(context.getString(R.string.language), "http://lc.hkbu.edu.hk/", "lc@hkbu.edu.hk", "(852) 3411 7589");
        HKBUDepartment music = new HKBUDepartment(context.getString(R.string.music), "http://mus.hkbu.edu.hk/", " mus@hkbu.edu.hk", "(852) 3411 5153");
        HKBUDepartment religion = new HKBUDepartment(context.getString(R.string.religion), "http://rel.hkbu.edu.hk", "rel@hkbu.edu.hk", "(852) 3411 7280");
        HKBUDepartment humanities = new HKBUDepartment(context.getString(R.string.humanities), "http://hum.hkbu.edu.hk/page.php", "(852) 3411 7192", "hmw@hkbu.edu.hk");
        HKBUDepartment translation = new HKBUDepartment(context.getString(R.string.translation), "http://tran.hkbu.edu.hk/", "trans(AT)hkbu.edu.hk", "(852) 3411 7205");
        HKBUDepartment accountingAndLaw = new HKBUDepartment(context.getString(R.string.accountingAndLaw), "http://aclw.hkbu.edu.hk/eng/main/Index", "", "");
        HKBUDepartment economics = new HKBUDepartment(context.getString(R.string.economics), "http://econ.hkbu.edu.hk/eng/main/Index", "econ@hkbu.edu.hk", "(852) 3411-7544");
        HKBUDepartment finance = new HKBUDepartment(context.getString(R.string.finance), "http://fds.hkbu.edu.hk/eng/main/Index", "fds@hkbu.edu.hk", "(852) 3411-7556");
        HKBUDepartment managment = new HKBUDepartment(context.getString(R.string.managment), "http://mgnt.hkbu.edu.hk/eng/main/Index", "mgnt@hkbu.edu.hk", "(852) 3411-7577");
        HKBUDepartment marketing = new HKBUDepartment(context.getString(R.string.marketing), "http://mkt.hkbu.edu.hk/eng/main/Index", "mkt@hkbu.edu.hk", "(852) 3411-7526 ");
        HKBUDepartment film = new HKBUDepartment(context.getString(R.string.film), "http://af.hkbu.edu.hk", context.getString(R.string.multiple), context.getString(R.string.multiple));
        HKBUDepartment communications = new HKBUDepartment(context.getString(R.string.communications), "http://www.coms.hkbu.edu.hk", "coms@hkbu.edu.hk", "(852) 3411 7224");
        HKBUDepartment journalism = new HKBUDepartment(context.getString(R.string.journalism), "http://journalism.hkbu.edu.hk", "jour@hkbu.edu.hk", " (852) 34117 490");
        HKBUDepartment medicine = new HKBUDepartment(context.getString(R.string.medicine), "http://scm.hkbu.edu.hk/en/home/index.php", "scm@hkbu.edu.hk", "(852) 3411 5387");
        HKBUDepartment biology = new HKBUDepartment(context.getString(R.string.biology), "biol.hkbu.edu.hk", "biol@hkbu.edu.hk", "(852) 3411 7050");
        HKBUDepartment chemistry = new HKBUDepartment(context.getString(R.string.chemistry), "http://chem.hkbu.edu.hk", "chem@hkbu.edu.hk", "(852) 3411-7063");
        HKBUDepartment computer = new HKBUDepartment(context.getString(R.string.computer), "https://www.comp.hkbu.edu.hk", " comp@comp.hkbu.edu.hk", "(852) 3411 7091");
        HKBUDepartment math = new HKBUDepartment(context.getString(R.string.math), "http://www.math.hkbu.edu.hk/", "mathdept@hkbu.edu.hk", " (852) 3411 2346");
        HKBUDepartment physics = new HKBUDepartment(context.getString(R.string.physics), "http://physics.hkbu.edu.hk/home", "phys@hkbu.edu.hk", "(852) 3411 5145");
        HKBUDepartment education = new HKBUDepartment(context.getString(R.string.education), "http://educ.hkbu.edu.hk", "educ@hkbu.edu.hk", "(852) 3411 5745");
        HKBUDepartment geography = new HKBUDepartment(context.getString(R.string.geography), "http://geog.hkbu.edu.hk", "geog@hkbu.edu.hk", "(852) 3411 7129");
        HKBUDepartment international = new HKBUDepartment(context.getString(R.string.international), "http://gis.hkbu.edu.hk", "gis@hkbu.edu.hk", "(852) 3411 5669");
        HKBUDepartment history = new HKBUDepartment(context.getString(R.string.history), "http://histweb.hkbu.edu.hk", " hist@hkbu.edu.hk", "(852) 3411 7107");
        HKBUDepartment physical = new HKBUDepartment(context.getString(R.string.physical), "http://pe.hkbu.edu.hk/eng", "pe@hkbu.edu.hk", "(852) 3411 7764");
        HKBUDepartment social = new HKBUDepartment(context.getString(R.string.social), "http://sowk.hkbu.edu.hk", "sowk@hkbu.edu.hk", "(852) 3411 7105");
        HKBUDepartment sociology = new HKBUDepartment(context.getString(R.string.sociology), "http://socweb.hkbu.edu.hk", "soc@hkbu.edu.hk", "(852) 3411-7131");
        HKBUDepartment ach = new HKBUDepartment(context.getString(R.string.ach), "http://www.ach.hkbu.edu.hk", "ach@hkbu.edu.hk", "(852) 3411 5182");
        HKBUDepartment library = new HKBUDepartment(context.getString(R.string.library), "http://library.hkbu.edu.hk/main/index.php", "libref@hkbu.edu.hk", "(852) 3411 7363");
        HKBUDepartment contEd = new HKBUDepartment(context.getString(R.string.contEd), "http://www.sce.hkbu.edu.hk", "sce@hkbu.edu.hk", "(852) 3411 5000");
        HKBUDepartment jointSports = new HKBUDepartment(context.getString(R.string.jointSports), "http://jsc.hkbu.edu.hk/", "jsc@hkbu.edu.hk", "(852) 2794 1168");
        HKBUDepartment lamwu = new HKBUDepartment(context.getString(R.string.lamwu), "http://www.ach.hkbu.edu.hk/nab_wlb", "ach@hkbu.edu.hk", "(852) 3411 5182");
        HKBUDepartment ntt = new HKBUDepartment(context.getString(R.string.ntt), "http://sass.hkbu.edu.hk/sass/ntt/guests/eng", "nttbook@hkbu.edu.hk", "(852) 2301 2301");
        HKBUDepartment ava = new HKBUDepartment(context.getString(R.string.ava), "http://ava.hkbu.edu.hk", "va@hkbu.edu.hk", "(852) 3411 8282");
        HKBUDepartment srh = new HKBUDepartment(context.getString(R.string.srh), "http://sa.hkbu.edu.hk/sass/ugh", "ughall@hkbu.edu.hk", "(852) 3411 2602");

        list.add(new HKBULocation(context.getString(R.string.MRH), "MRH", "stb_ash_mrh", 22.341416, 114.179505, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
        list.add(new HKBULocation(context.getString(R.string.ASH), "ASH", "stb_ash_mrh", 22.341437, 114.180049, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
        list.add(new HKBULocation(context.getString(R.string.STB), "STB", "stb_ash_mrh", 22.341337, 114.180272, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
        list.add(new HKBULocation(context.getString(R.string.ACH), "ACH", "ach_and_lmc", 22.341195, 114.179945, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(ach))));
        list.add(new HKBULocation(context.getString(R.string.LMC), "LMC", "ach_and_lmc", 22.341153, 114.179569, HKBULocation.Campus.HSH, null));
        list.add(new HKBULocation(context.getString(R.string.CEC), "CEC", "cec", 22.341148, 114.180276, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(religion))));
        list.add(new HKBULocation(context.getString(R.string.OEM), "OEM", "oem", 22.340864, 114.179909, HKBULocation.Campus.HSH, null));
        list.add(new HKBULocation(context.getString(R.string.OEW), "OEW", "oew", 22.340831, 114.180301, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(english, translation))));
        list.add(new HKBULocation(context.getString(R.string.OEE), "OEE", "oee", 22.340755, 114.179614, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(chinese, language))));
        list.add(new HKBULocation(context.getString(R.string.SCT), "SCT", "sct", 22.340573, 114.179957, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(biology, chemistry, physics))));
        list.add(new HKBULocation(context.getString(R.string.YSS), "YSS", "yss", 22.340407, 114.180359, HKBULocation.Campus.HSH, null));
        list.add(new HKBULocation(context.getString(R.string.RRS), "RRS", "rrs", 22.340223, 114.179690, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(humanities, computer))));
        list.add(new HKBULocation(context.getString(R.string.FSC), "FSC", "fsc", 22.340233, 114.180170, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(math))));
        list.add(new HKBULocation(context.getString(R.string.MLG), "MLG", "mlg", 22.339805, 114.180740, HKBULocation.Campus.HSH, null));
        list.add(new HKBULocation(context.getString(R.string.FC), "FC", "fc", 22.339319, 114.180743, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(contEd))));
        list.add(new HKBULocation(context.getString(R.string.WHS), "WHS", "whs", 22.339650, 114.181656, HKBULocation.Campus.HSH, null));

        list.add(new HKBULocation(context.getString(R.string.SWT), "SWT", "swt", 22.338762, 114.182015, HKBULocation.Campus.SHAW, null));
        list.add(new HKBULocation(context.getString(R.string.AML), "AML", "aml", 22.338310, 114.181956, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(library))));
        list.add(new HKBULocation(context.getString(R.string.JSC), "JSC", "jsc", 22.337732, 114.182251, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(jointSports))));
        list.add(new HKBULocation(context.getString(R.string.WLB), "WLB", "wlb", 22.337859, 114.181779, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(accountingAndLaw, economics, finance, managment, marketing))));
        list.add(new HKBULocation(context.getString(R.string.LWC), "LWC", "lwc", 22.337396, 114.181951, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(lamwu))));
        list.add(new HKBULocation(context.getString(R.string.DLB), "DLB", "dlb", 22.337304, 114.181742, HKBULocation.Campus.SHAW, null));
        list.add(new HKBULocation(context.getString(R.string.SCC), "SCC", "scc", 22.337120, 114.182211, HKBULocation.Campus.SHAW, null));

        list.add(new HKBULocation(context.getString(R.string.AAB), "AAB", "aab", 22.336570, 114.182019, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(education, geography, international, history, physical, social, sociology))));
        list.add(new HKBULocation(context.getString(R.string.NTT), "NTT", "ntt", 22.336367, 114.181791, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ntt))));
        list.add(new HKBULocation(context.getString(R.string.ACC), "ACC", "acc", 22.336367, 114.181791, HKBULocation.Campus.BUR, null));
        list.add(new HKBULocation(context.getString(R.string.SCE), "SCE", "sce", 22.336074, 114.182732, HKBULocation.Campus.BUR, null));
        list.add(new HKBULocation(context.getString(R.string.SCM), "SCM", "scm", 22.335682, 114.182622, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(medicine))));
        list.add(new HKBULocation(context.getString(R.string.SRHN), "SRHN", "srh_north", 22.335387, 114.182539, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
        list.add(new HKBULocation(context.getString(R.string.SRHS), "SRHS", "srh_south", 22.335050, 114.182518, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
        list.add(new HKBULocation(context.getString(R.string.CVA), "CVA", "cva", 22.334251, 114.182440, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ava, film, communications, journalism))));
        Collections.sort(list);

        locations = new HKBULocation[list.size()];
        locations = list.toArray(locations);

        simpleLocations = new ArrayList<>();

        simpleLocations.add(new HKBUSimpleLocation(context.getString(R.string.pacfic), HKBUSimpleLocation.LocationType.COFFEE, new ArrayList<>(Arrays.asList(new Coordinates(22.337866, 114.181851)))));
        simpleLocations.add(new HKBUSimpleLocation(context.getString(R.string.starbucks), HKBUSimpleLocation.LocationType.COFFEE, new ArrayList<>(Arrays.asList(new Coordinates(22.336181, 114.182740)))));
        simpleLocations.add(new HKBUSimpleLocation(context.getString(R.string.atm), HKBUSimpleLocation.LocationType.ATM, new ArrayList<>(Arrays.asList(new Coordinates(22.338767, 114.182088), new Coordinates(22.336070, 114.182716), new Coordinates(22.337092, 114.181921), new Coordinates(22.339606, 114.180286), new Coordinates(22.340531, 114.179554)))));
        simpleLocations.add(new HKBUSimpleLocation(context.getString(R.string.hsbank), HKBUSimpleLocation.LocationType.BANK, new ArrayList<>(Arrays.asList(new Coordinates(22.336065, 114.182893), new Coordinates(22.340221, 114.179664)))));
        simpleLocations.add(new HKBUSimpleLocation(context.getString(R.string.canteen), HKBUSimpleLocation.LocationType.CANTEEN, new ArrayList<>(Arrays.asList(new Coordinates(22.335355, 114.182452), new Coordinates(22.340289, 114.179787)))));
    }

    // Thread-safe Singleton
    public static HKBULocation[] getLocations(String lang) {
        if (locationCreator == null) {
            synchronized (LocationCreator.class) {
                if (locationCreator == null) {
                    locationCreator = new LocationCreator(lang);
                }
            }
        }
        return locationCreator.locations;
    }

    public static ArrayList<HKBUSimpleLocation> getSimpleLocations(String lang) {
        if (locationCreator == null) {
            synchronized (LocationCreator.class) {
                if (locationCreator == null) {
                    locationCreator = new LocationCreator(lang);
                }
            }
        }
        return locationCreator.simpleLocations;
    }
}
