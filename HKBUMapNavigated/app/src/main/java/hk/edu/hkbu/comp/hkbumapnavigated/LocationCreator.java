package hk.edu.hkbu.comp.hkbumapnavigated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocationCreator {

    private HKBULocation[] locations;
    private static volatile LocationCreator locationCreator = null;

    private LocationCreator(String lang) {
        initLocations(lang);
    }

    private void initLocations(String lang) {
        List<HKBULocation> list = new ArrayList<>();
        if(lang.startsWith("zh")) {
            HKBUDepartment chinese = new HKBUDepartment("中國語言文學系", "http://chi.hkbu.edu.hk", "chi@hkbu.edu.hk", "(852) 3411 7891");
            HKBUDepartment english = new HKBUDepartment("英國語言文學系", "http://eng.hkbu.edu.hk", "eng@hkbu.edu.hk", "(852) 3411 7171");
            HKBUDepartment language = new HKBUDepartment("語文中心", "http://lc.hkbu.edu.hk/", "lc@hkbu.edu.hk", "(852) 3411 7589");
            HKBUDepartment music = new HKBUDepartment("音樂系", "http://mus.hkbu.edu.hk/", " mus@hkbu.edu.hk", "(852) 3411 5153");
            HKBUDepartment religion = new HKBUDepartment("宗教及哲學系", "http://rel.hkbu.edu.hk", "rel@hkbu.edu.hk", "(852) 3411 7280");
            HKBUDepartment humanities = new HKBUDepartment("人文及創作系", "http://hum.hkbu.edu.hk/page.php", "(852) 3411 7192", "hmw@hkbu.edu.hk");
            HKBUDepartment translation = new HKBUDepartment("翻譯學", "http://tran.hkbu.edu.hk/", "trans(AT)hkbu.edu.hk", "(852) 3411 7205");
            HKBUDepartment accountingAndLaw = new HKBUDepartment("會計及法律系", "http://aclw.hkbu.edu.hk/eng/main/Index", "", "");
            HKBUDepartment economics = new HKBUDepartment("經濟系", "http://econ.hkbu.edu.hk/eng/main/Index", "econ@hkbu.edu.hk", "(852) 3411-7544");
            HKBUDepartment finance = new HKBUDepartment("財務及決策學系", "http://fds.hkbu.edu.hk/eng/main/Index", "fds@hkbu.edu.hk", "(852) 3411-7556");
            HKBUDepartment managment = new HKBUDepartment("管理學系", "http://mgnt.hkbu.edu.hk/eng/main/Index", "mgnt@hkbu.edu.hk", "(852) 3411-7577");
            HKBUDepartment marketing = new HKBUDepartment("市場學系", "http://mkt.hkbu.edu.hk/eng/main/Index", "mkt@hkbu.edu.hk", "(852) 3411-7526 ");
            HKBUDepartment film = new HKBUDepartment("電影學院", "http://af.hkbu.edu.hk", "Multiple, see website.", "Multiple, see website.");
            HKBUDepartment communications = new HKBUDepartment("communications", "http://www.coms.hkbu.edu.hk", "coms@hkbu.edu.hk", "(852) 3411 7224");
            HKBUDepartment journalism = new HKBUDepartment("新聞系", "http://journalism.hkbu.edu.hk", "jour@hkbu.edu.hk", " (852) 34117 490");
            HKBUDepartment medicine = new HKBUDepartment("中醫藥學", "http://scm.hkbu.edu.hk/en/home/index.php", "scm@hkbu.edu.hk", "(852) 3411 5387");
            HKBUDepartment biology = new HKBUDepartment("生物系", "biol.hkbu.edu.hk", "biol@hkbu.edu.hk", "(852) 3411 7050");
            HKBUDepartment chemistry = new HKBUDepartment("化學系", "http://chem.hkbu.edu.hk", "chem@hkbu.edu.hk", "(852) 3411-7063");
            HKBUDepartment computer = new HKBUDepartment("計算機科學系", "https://www.comp.hkbu.edu.hk", " comp@comp.hkbu.edu.hk", "(852) 3411 7091");
            HKBUDepartment math = new HKBUDepartment("數學系", "http://www.math.hkbu.edu.hk/", "mathdept@hkbu.edu.hk", " (852) 3411 2346");
            HKBUDepartment physics = new HKBUDepartment("物理系", "http://physics.hkbu.edu.hk/home", "phys@hkbu.edu.hk", "(852) 3411 5145");
            HKBUDepartment education = new HKBUDepartment("教育學系", "http://educ.hkbu.edu.hk", "educ@hkbu.edu.hk", "(852) 3411 5745");
            HKBUDepartment geography = new HKBUDepartment("地理系", "http://geog.hkbu.edu.hk", "geog@hkbu.edu.hk", "(852) 3411 7129");
            HKBUDepartment international = new HKBUDepartment("政治及國際關係學系", "http://gis.hkbu.edu.hk", "gis@hkbu.edu.hk", "(852) 3411 5669");
            HKBUDepartment history = new HKBUDepartment("歷史系", "http://histweb.hkbu.edu.hk", " hist@hkbu.edu.hk", "(852) 3411 7107");
            HKBUDepartment physical = new HKBUDepartment("體育學系", "http://pe.hkbu.edu.hk/eng", "pe@hkbu.edu.hk", "(852) 3411 7764");
            HKBUDepartment social = new HKBUDepartment("社會工作系", "http://sowk.hkbu.edu.hk", "sowk@hkbu.edu.hk", "(852) 3411 7105");
            HKBUDepartment sociology = new HKBUDepartment("社會學系", "http://socweb.hkbu.edu.hk", "soc@hkbu.edu.hk", "(852) 3411-7131");
            HKBUDepartment ach = new HKBUDepartment("大學會堂", "http://www.ach.hkbu.edu.hk", "ach@hkbu.edu.hk", "(852) 3411 5182");
            HKBUDepartment library = new HKBUDepartment("方樹泉圖書館", "http://library.hkbu.edu.hk/main/index.php", "libref@hkbu.edu.hk", "(852) 3411 7363");
            HKBUDepartment contEd = new HKBUDepartment("持續教育學院", "http://www.sce.hkbu.edu.hk", "sce@hkbu.edu.hk", "(852) 3411 5000");
            HKBUDepartment jointSports = new HKBUDepartment("聯校運動中心", "http://jsc.hkbu.edu.hk/", "jsc@hkbu.edu.hk", "(852) 2794 1168");
            HKBUDepartment lamwu = new HKBUDepartment("林護國際會議中心", "http://www.ach.hkbu.edu.hk/nab_wlb", "ach@hkbu.edu.hk", "(852) 3411 5182");
            HKBUDepartment ntt = new HKBUDepartment("吳多泰博士國際中心", "http://sass.hkbu.edu.hk/sass/ntt/guests/eng", "nttbook@hkbu.edu.hk", "(852) 2301 2301");
            HKBUDepartment ava = new HKBUDepartment("視覺藝術院", "http://ava.hkbu.edu.hk", "va@hkbu.edu.hk", "(852) 3411 8282");
            HKBUDepartment srh = new HKBUDepartment("學生舍堂", "http://sa.hkbu.edu.hk/sass/ugh", "ughall@hkbu.edu.hk", "(852) 3411 2602");

            list.add(new HKBULocation("音樂綵排室", "MRH", "stb_ash_mrh", 22.341416, 114.179505, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("區樹洪樓", "ASH", "stb_ash_mrh", 22.341437, 114.180049, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("星島樓", "STB", "stb_ash_mrh", 22.341337, 114.180272, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("大學會堂", "ACH", "ach_and_lmc", 22.341195, 114.179945, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(ach))));
            list.add(new HKBULocation("呂明才中心", "LMC", "ach_and_lmc", 22.341153, 114.179569, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("基督教教育中心", "CEC", "cec", 22.341148, 114.180276, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(religion))));
            list.add(new HKBULocation("溫仁才大樓主樓", "OEM", "oem", 22.340864, 114.179909, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("溫仁才大樓西翼", "OEW", "oew", 22.340831, 114.180301, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(english, translation))));
            list.add(new HKBULocation("溫仁才大樓東翼", "OEE", "oee", 22.340755, 114.179614, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(chinese, language))));
            list.add(new HKBULocation("查濟民科學大樓", "SCT", "sct", 22.340573, 114.179957, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(biology, chemistry, physics))));
            list.add(new HKBULocation("楊瑞生紀念館", "YSS", "yss", 22.340407, 114.180359, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("邵逸夫大樓", "RRS", "rrs", 22.340223, 114.179690, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(humanities, computer))));
            list.add(new HKBULocation("方樹泉圖書館", "FSC", "fsc", 22.340233, 114.180170, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(math))));
            list.add(new HKBULocation("文農學圃", "MLG", "mlg", 22.339805, 114.180740, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("建生中心", "FC", "fc", 22.339319, 114.180743, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(contEd))));
            list.add(new HKBULocation("偉衡體育中心", "WHS", "whs", 22.339650, 114.181656, HKBULocation.Campus.HSH, null));

            list.add(new HKBULocation("逸夫行政樓", "SWT", "swt", 22.338762, 114.182015, HKBULocation.Campus.SHAW, null));
            list.add(new HKBULocation("區樹洪紀念圖書館", "AML", "aml", 22.338310, 114.181956, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(library))));
            list.add(new HKBULocation("聯校運動中心", "JSC", "jsc", 22.337732, 114.182251, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(jointSports))));
            list.add(new HKBULocation("永隆銀行商學大樓", "WLB", "wlb", 22.337859, 114.181779, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(accountingAndLaw, economics, finance, managment, marketing))));
            list.add(new HKBULocation("林護國際會議中心", "LWC", "lwc", 22.337396, 114.181951, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(lamwu))));
            list.add(new HKBULocation("思齊樓", "DLB", "dlb", 22.337304, 114.181742, HKBULocation.Campus.SHAW, null));
            list.add(new HKBULocation("郭鍾寶芬女士康體文娛中心", "SCC", "scc", 22.337120, 114.182211, HKBULocation.Campus.SHAW, null));

            list.add(new HKBULocation("教學及行政大樓", "AAB", "aab", 22.336570, 114.182019, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(education, geography, international, history, physical, social, sociology))));
            list.add(new HKBULocation("吳多泰博士國際中心", "NTT", "ntt", 22.336367, 114.181791, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ntt))));
            list.add(new HKBULocation("賽馬會師生活動中心", "ACC", "acc", 22.336367, 114.181791, HKBULocation.Campus.BUR, null));
            list.add(new HKBULocation("香港浸會大學持續教育學院", "SCE", "sce", 22.336074, 114.182732, HKBULocation.Campus.BUR, null));
            list.add(new HKBULocation("賽馬會中醫藥學院大樓", "SCM", "scm", 22.335682, 114.182622, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(medicine))));
            list.add(new HKBULocation("學生舍堂北", "SRHN", "srh_north", 22.335387, 114.182539, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
            list.add(new HKBULocation("學生舍堂南", "SRHS", "srh_south", 22.335050, 114.182518, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
            list.add(new HKBULocation("傳理視藝大樓", "CVA", "cva", 22.334251, 114.182440, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ava, film, communications, journalism))));
        }
        else{
            HKBUDepartment chinese = new HKBUDepartment("Department of Chinese Language and Literature", "http://chi.hkbu.edu.hk", "chi@hkbu.edu.hk", "(852) 3411 7891");
            HKBUDepartment english = new HKBUDepartment("Department of English Language and Literature", "http://eng.hkbu.edu.hk", "eng@hkbu.edu.hk", "(852) 3411 7171");
            HKBUDepartment language = new HKBUDepartment("Language Centre", "http://lc.hkbu.edu.hk/", "lc@hkbu.edu.hk", "(852) 3411 7589");
            HKBUDepartment music = new HKBUDepartment("Department of Music", "http://mus.hkbu.edu.hk/", " mus@hkbu.edu.hk", "(852) 3411 5153");
            HKBUDepartment religion = new HKBUDepartment("Department of Religion and Philosophy", "http://rel.hkbu.edu.hk", "rel@hkbu.edu.hk", "(852) 3411 7280");
            HKBUDepartment humanities = new HKBUDepartment("Department of Humanities and Creative Writing", "http://hum.hkbu.edu.hk/page.php", "(852) 3411 7192", "hmw@hkbu.edu.hk");
            HKBUDepartment translation = new HKBUDepartment("Translation Programme", "http://tran.hkbu.edu.hk/", "trans(AT)hkbu.edu.hk", "(852) 3411 7205");
            HKBUDepartment accountingAndLaw = new HKBUDepartment("Department of Accountancy and Law", "http://aclw.hkbu.edu.hk/eng/main/Index", "", "");
            HKBUDepartment economics = new HKBUDepartment("Department of Economics", "http://econ.hkbu.edu.hk/eng/main/Index", "econ@hkbu.edu.hk", "(852) 3411-7544");
            HKBUDepartment finance = new HKBUDepartment("Department of Finance and Decision Sciences", "http://fds.hkbu.edu.hk/eng/main/Index", "fds@hkbu.edu.hk", "(852) 3411-7556");
            HKBUDepartment managment = new HKBUDepartment("Department of Management", "http://mgnt.hkbu.edu.hk/eng/main/Index", "mgnt@hkbu.edu.hk", "(852) 3411-7577");
            HKBUDepartment marketing = new HKBUDepartment("Department of Marketing", "http://mkt.hkbu.edu.hk/eng/main/Index", "mkt@hkbu.edu.hk", "(852) 3411-7526 ");
            HKBUDepartment film = new HKBUDepartment("Academy of Film", "http://af.hkbu.edu.hk", "Multiple, see website.", "Multiple, see website.");
            HKBUDepartment communications = new HKBUDepartment("Department of Communication Studies", "http://www.coms.hkbu.edu.hk", "coms@hkbu.edu.hk", "(852) 3411 7224");
            HKBUDepartment journalism = new HKBUDepartment("Department of Journalism", "http://journalism.hkbu.edu.hk", "jour@hkbu.edu.hk", " (852) 34117 490");
            HKBUDepartment medicine = new HKBUDepartment("Chinese Medicine Programme", "http://scm.hkbu.edu.hk/en/home/index.php", "scm@hkbu.edu.hk", "(852) 3411 5387");
            HKBUDepartment biology = new HKBUDepartment("Department of Biology", "biol.hkbu.edu.hk", "biol@hkbu.edu.hk", "(852) 3411 7050");
            HKBUDepartment chemistry = new HKBUDepartment("Department of Chemistry", "http://chem.hkbu.edu.hk", "chem@hkbu.edu.hk", "(852) 3411-7063");
            HKBUDepartment computer = new HKBUDepartment("Department of Computer Science", "https://www.comp.hkbu.edu.hk", " comp@comp.hkbu.edu.hk", "(852) 3411 7091");
            HKBUDepartment math = new HKBUDepartment("Department of Mathematics", "http://www.math.hkbu.edu.hk/", "mathdept@hkbu.edu.hk", " (852) 3411 2346");
            HKBUDepartment physics = new HKBUDepartment("Department of Physics", "http://physics.hkbu.edu.hk/home", "phys@hkbu.edu.hk", "(852) 3411 5145");
            HKBUDepartment education = new HKBUDepartment("Department of Education Studies", "http://educ.hkbu.edu.hk", "educ@hkbu.edu.hk", "(852) 3411 5745");
            HKBUDepartment geography = new HKBUDepartment("Department of Geography", "http://geog.hkbu.edu.hk", "geog@hkbu.edu.hk", "(852) 3411 7129");
            HKBUDepartment international = new HKBUDepartment("Department of Government and International Studies", "http://gis.hkbu.edu.hk", "gis@hkbu.edu.hk", "(852) 3411 5669");
            HKBUDepartment history = new HKBUDepartment("Department of History", "http://histweb.hkbu.edu.hk", " hist@hkbu.edu.hk", "(852) 3411 7107");
            HKBUDepartment physical = new HKBUDepartment("Department of Physical Education", "http://pe.hkbu.edu.hk/eng", "pe@hkbu.edu.hk", "(852) 3411 7764");
            HKBUDepartment social = new HKBUDepartment("Department of Social Work", "http://sowk.hkbu.edu.hk", "sowk@hkbu.edu.hk", "(852) 3411 7105");
            HKBUDepartment sociology = new HKBUDepartment("Department of Sociology", "http://socweb.hkbu.edu.hk", "soc@hkbu.edu.hk", "(852) 3411-7131");
            HKBUDepartment ach = new HKBUDepartment("Academic Community Hall", "http://www.ach.hkbu.edu.hk", "ach@hkbu.edu.hk", "(852) 3411 5182");
            HKBUDepartment library = new HKBUDepartment("Fong Shu Chuen Library", "http://library.hkbu.edu.hk/main/index.php", "libref@hkbu.edu.hk", "(852) 3411 7363");
            HKBUDepartment contEd = new HKBUDepartment("School of Continuing Education", "http://www.sce.hkbu.edu.hk", "sce@hkbu.edu.hk", "(852) 3411 5000");
            HKBUDepartment jointSports = new HKBUDepartment("Joint Sports Centre", "http://jsc.hkbu.edu.hk/", "jsc@hkbu.edu.hk", "(852) 2794 1168");
            HKBUDepartment lamwu = new HKBUDepartment("Lam Wu International Conference Centre", "http://www.ach.hkbu.edu.hk/nab_wlb", "ach@hkbu.edu.hk", "(852) 3411 5182");
            HKBUDepartment ntt = new HKBUDepartment("Dr. Ng Tor Tai International House", "http://sass.hkbu.edu.hk/sass/ntt/guests/eng", "nttbook@hkbu.edu.hk", "(852) 2301 2301");
            HKBUDepartment ava = new HKBUDepartment("Academy of Visual Arts", "http://ava.hkbu.edu.hk", "va@hkbu.edu.hk", "(852) 3411 8282");
            HKBUDepartment srh = new HKBUDepartment("Student Residence Halls", "http://sa.hkbu.edu.hk/sass/ugh", "ughall@hkbu.edu.hk", "(852) 3411 2602");

            list.add(new HKBULocation("Music Rehearsal Hall", "MRH", "stb_ash_mrh", 22.341416, 114.179505, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("Au Shue Hung Building", "ASH", "stb_ash_mrh", 22.341437, 114.180049, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("Sing Tao Building", "STB", "stb_ash_mrh", 22.341337, 114.180272, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(music))));
            list.add(new HKBULocation("Academic Community Hall", "ACH", "ach_and_lmc", 22.341195, 114.179945, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(ach))));
            list.add(new HKBULocation("Lui Ming Choi Centre", "LMC", "ach_and_lmc", 22.341153, 114.179569, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("Christian Education Centre", "CEC", "cec", 22.341148, 114.180276, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(religion))));
            list.add(new HKBULocation("Oen Hall Main", "OEM", "oem", 22.340864, 114.179909, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("Oen Hall West", "OEW", "oew", 22.340831, 114.180301, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(english, translation))));
            list.add(new HKBULocation("Oen Hall East", "OEE", "oee", 22.340755, 114.179614, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(chinese, language))));
            list.add(new HKBULocation("Cha Chi-ming Science Tower", "SCT", "sct", 22.340573, 114.179957, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(biology, chemistry, physics))));
            list.add(new HKBULocation("Yeung Shui Sang Building", "YSS", "yss", 22.340407, 114.180359, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("Sir Run Run Shaw Building", "RRS", "rrs", 22.340223, 114.179690, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(humanities, computer))));
            list.add(new HKBULocation("Fong Shu Chuen Library", "FSC", "fsc", 22.340233, 114.180170, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(math))));
            list.add(new HKBULocation("Man Lung Garden", "MLG", "mlg", 22.339805, 114.180740, HKBULocation.Campus.HSH, null));
            list.add(new HKBULocation("Franki Centre", "FC", "fc", 22.339319, 114.180743, HKBULocation.Campus.HSH, new ArrayList<>(Arrays.asList(contEd))));
            list.add(new HKBULocation("Wai Hang Sports Centre", "WHS", "whs", 22.339650, 114.181656, HKBULocation.Campus.HSH, null));

            list.add(new HKBULocation("Shaw Tower", "SWT", "swt", 22.338762, 114.182015, HKBULocation.Campus.SHAW, null));
            list.add(new HKBULocation("Au Shue Hung Memorial Library", "AML", "aml", 22.338310, 114.181956, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(library))));
            list.add(new HKBULocation("Joint Sports Centre", "JSC", "jsc", 22.337732, 114.182251, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(jointSports))));
            list.add(new HKBULocation("Wing Lung Bank Building", "WLB", "wlb", 22.337859, 114.181779, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(accountingAndLaw, economics, finance, managment, marketing))));
            list.add(new HKBULocation("Lam Woo International Conference Centre", "LWC", "lwc", 22.337396, 114.181951, HKBULocation.Campus.SHAW, new ArrayList<>(Arrays.asList(lamwu))));
            list.add(new HKBULocation("David C. Lam Building", "DLB", "dlb", 22.337304, 114.181742, HKBULocation.Campus.SHAW, null));
            list.add(new HKBULocation("Madam Kwok Chung Bo Fun Sports and Cultural Centre", "SCC", "scc", 22.337120, 114.182211, HKBULocation.Campus.SHAW, null));

            list.add(new HKBULocation("Academic and Administration Building", "AAB", "aab", 22.336570, 114.182019, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(education, geography, international, history, physical, social, sociology))));
            list.add(new HKBULocation("Dr. Ng Tor Tai International House", "NTT", "ntt", 22.336367, 114.181791, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ntt))));
            list.add(new HKBULocation("Jockey Club Academic Community Centre", "ACC", "acc", 22.336367, 114.181791, HKBULocation.Campus.BUR, null));
            list.add(new HKBULocation("Madam Chan Wu Wan Kwai School of Continuing Education", "SCE", "sce", 22.336074, 114.182732, HKBULocation.Campus.BUR, null));
            list.add(new HKBULocation("Jockey Club School of Chinese Medicine Building", "SCM", "scm", 22.335682, 114.182622, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(medicine))));
            list.add(new HKBULocation("Student Residence Halls North", "SRHN", "srh_north", 22.335387, 114.182539, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
            list.add(new HKBULocation("Student Residence Halls South", "SRHS", "srh_south", 22.335050, 114.182518, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(srh))));
            list.add(new HKBULocation("Communication and Visual Arts Building", "CVA", "cva", 22.334251, 114.182440, HKBULocation.Campus.BUR, new ArrayList<>(Arrays.asList(ava, film, communications, journalism))));
        }
        Collections.sort(list);

        locations = new HKBULocation[list.size()];
        locations = list.toArray(locations);
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
}
