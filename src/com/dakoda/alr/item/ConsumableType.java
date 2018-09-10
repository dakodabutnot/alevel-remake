package com.dakoda.alr.item;

public enum ConsumableType {

    HEALTH("Health"),
    ENERGY("Energy"),
    MANA("Mana"),
    EXPERIENCE("Experience");

    private String displayText;

    ConsumableType(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
