package com.dakoda.alr.world.item.attr;

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
