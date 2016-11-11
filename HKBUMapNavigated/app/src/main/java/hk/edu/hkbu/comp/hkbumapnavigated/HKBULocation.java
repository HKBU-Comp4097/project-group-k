package hk.edu.hkbu.comp.hkbumapnavigated;

public class HKBULocation implements Comparable<HKBULocation>{
    private String image;
    private String name;
    private String abbreviation;
    private double latitude;
    private double longitude;

    public HKBULocation(String name, String abbreviation, String image, double latitude, double longitude) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
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
