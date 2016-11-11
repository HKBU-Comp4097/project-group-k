package hk.edu.hkbu.comp.hkbumapnavigated;

import android.location.Location;

public class HKBULocation {
    private String image;
    private String name;
    private String abbreviation;
    private Location location;

    public HKBULocation(String name, String abbreviation, String image){//}, Location location){
        this.name = name;
        this.abbreviation = abbreviation;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }
}
