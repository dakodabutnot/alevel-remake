package com.dakoda.alr.game;

public enum Profession {

    WARRIOR("Warrior"),
    RANGER("Ranger"),
    MAGE("Mage");

    private String displayText;

    Profession(
            String displayText
    ) {

        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
