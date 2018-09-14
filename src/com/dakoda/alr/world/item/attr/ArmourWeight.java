package com.dakoda.alr.world.item.attr;

public enum ArmourWeight {

    LIGHT("Light"),
    MEDIUM("Medium"),
    HEAVY("Heavy");

    private String displayText;

    ArmourWeight(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
