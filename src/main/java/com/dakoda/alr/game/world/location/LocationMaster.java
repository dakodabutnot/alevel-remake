package com.dakoda.alr.game.world.location;

public class LocationMaster {

    private Location currentLocation = null;

    public Location currentLocation() {
        return currentLocation;
    }

    public void changeLocation(Location location) {
        this.currentLocation = location;
    }

}
