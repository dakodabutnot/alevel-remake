package com.dakoda.alr.game.world.location;

public class LocationMaster {

    private static LocationMaster INSTANCE = new LocationMaster();

    private LocationMaster() {

    }

    public static LocationMaster instance() {
        return INSTANCE;
    }

    private Location currentLocation = null;

    public Location currentLocation() {
        return currentLocation;
    }

    public void changeLocation(Location location) {
        this.currentLocation = location;
    }

}
