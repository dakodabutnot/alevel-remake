package com.dakoda.alr.loc;

public enum LocationType {

    FIELD("Field"),             // hostiles, no rest
    CAMP("Camp"),               // hostiles, rest
    SETTLEMENT("Settlement"),   // no hostiles, no rest
    ESTATE("Estate"),           // no hostiles, no rest
    INN("Inn");                 // no hostiles, rest, merchant

    private String displayText;

    LocationType(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
