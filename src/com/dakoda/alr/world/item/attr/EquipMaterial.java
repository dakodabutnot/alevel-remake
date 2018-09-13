package com.dakoda.alr.world.item.attr;

import static com.dakoda.alr.world.item.attr.ArmourLevel.*;

public enum EquipMaterial {

    LEATHER("Leather", MEDIUM),
    HIDE("Hide", MEDIUM),
    REINFORCED_LEATHER("Reinforced leather", MEDIUM),

    SILK("Silk", LIGHT),
    CLOTH("Cloth", LIGHT),
    MANA_SILK("Mana-infused silk", LIGHT),

    COPPER("Copper", HEAVY),
    SILVER("Silver", HEAVY),
    IRON("Iron", HEAVY),
    BRONZE("Bronze", HEAVY),
    MITHRIL("Mithril", HEAVY),
    DRACONIUM("Draconium", HEAVY);
    // TODO: 12/09/2018 come up with better names please

    private String displayText;
    private ArmourLevel armourLevel;

    EquipMaterial(
            String displayText,
            ArmourLevel armourLevel
    ) {
        this.displayText = displayText;
        this.armourLevel = armourLevel;
    }

    public String getDisplayText() {
        return displayText;
    }

    public ArmourLevel getArmourLevel() {
        return armourLevel;
    }
}
