package com.dakoda.alr.item.equip;
import com.dakoda.alr.item.equip.armour.ArmourLevel;

import static com.dakoda.alr.item.equip.armour.ArmourLevel.*;

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
    /* TODO: 31/08/2018; 3:31 PM; come up with better names for higher-tier materials
        "draconium" is such a cliche
     */

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
