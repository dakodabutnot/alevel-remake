package com.dakoda.alr.game.world.location;

public enum LocationType {

    FIELD("Field", true, false),
    CAMP("Camp", true, true),
    SETTLEMENT("Settlement", false, false),
    ESTATE("Estate", false, false),
    INN("Inn", false, true);

    private String displayText;
    private boolean encounterable;
    private boolean restable;

    LocationType(
            String displayText,
            boolean encounterable,
            boolean restable
    ) {
        this.displayText = displayText;
        this.encounterable = encounterable;
        this.restable = restable;
    }

    public String getDisplayText() {
        return displayText;
    }

    public boolean isEncounterable() {
        return encounterable;
    }

    public boolean isRestable() {
        return restable;
    }
}
