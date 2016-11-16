package hk.edu.hkbu.comp.hkbumapnavigated;

import java.util.ArrayList;

public class HKBUSimpleLocation {
    private String name;
    private ArrayList<Coordinates> coordinates;
    private LocationType locationType;

    public enum LocationType {
        ATM, BANK, CANTEEN, COFFEE
    }

    public HKBUSimpleLocation(String name, LocationType locationType,ArrayList<Coordinates> coordinates) {
        this.name = name;
        this.locationType = locationType;
        if (coordinates == null) {
            this.coordinates = new ArrayList<>();
        } else {
            this.coordinates = coordinates;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public LocationType getLocationType() {
        return locationType;
    }

}