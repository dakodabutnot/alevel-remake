package com.dakoda.alr.item.equip.armour;

public enum ArmourLevel {

    LIGHT("Light"),
    MEDIUM("Medium"),
    HEAVY("Heavy");

    private String displayText;

    ArmourLevel(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
