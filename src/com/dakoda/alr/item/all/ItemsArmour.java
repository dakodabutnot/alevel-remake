package com.dakoda.alr.item.all;

import com.dakoda.alr.item.equip.armour.Armour;

public enum ItemsArmour {

    ;

    private final Armour item;

    ItemsArmour(
            Armour item
    ) {
        this.item = item;
    }

    public Armour get() {
        return item;
    }
}
