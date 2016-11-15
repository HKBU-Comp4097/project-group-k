package hk.edu.hkbu.comp.hkbumapnavigated;

import java.util.ArrayList;

public class HKBULocation implements Comparable<HKBULocation>{
    private String image;
    private String name;
    private String abbreviation;
    private double latitude;
    private double longitude;
    private Campus campus;
    private ArrayList<HKBUDepartment> departments;


    public enum Campus {SHAW("Shaw Campus"), HSH("Ho Sin Hang Campus"), BUR("Baptist University Road Campus");

        private String name;

        Campus(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public HKBULocation(String name, String abbreviation, String image, double latitude, double longitude, Campus campus, ArrayList<HKBUDepartment> departments) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.campus = campus;
        this.departments = departments;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCampus() {
        return campus.toString();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public ArrayList<HKBUDepartment> getDepartments() {
        return departments;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HKBULocation)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (((HKBULocation) object).getName().equals(this.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(HKBULocation location) {
        return this.getName().compareTo(location.getName());
    }
}
