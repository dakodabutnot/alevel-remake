package com.dakoda.alr.item;

public enum ItemType {

    JUNK("Junk"),
    CRAFTING_MATERIAL("Crafting material"),
    CONSUMABLE("Consumable"),
    WEAPON("Weapon"),
    ARMOUR("Armour"),
    TREASURE("Treasure"),
    QUEST("Quest item");

    private String displayText;

    ItemType(
            String displayText
    ) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
