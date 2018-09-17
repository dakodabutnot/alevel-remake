package com.dakoda.alr.game.world.item.attribute;

public enum ArmourEquipSlot {

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

    ArmourEquipSlot(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
