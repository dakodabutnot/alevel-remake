package com.dakoda.alr.item.equip.armour;

public enum ArmourSlot {

    HEAD("Head"),
    SHOULDER("Shoulder"),
    BACK("Back"),
    BODY("Body"),
    LEGS("Legs"),
    FEET("Feet"),
    HANDS("Hands"),
    TRINKET("Trinket"),
    RING("Ring"),
    NECKLACE("Necklace");

    private String displayText;

    private String heavyText;
    private String mediumText;
    private String lightText;

    ArmourSlot(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
