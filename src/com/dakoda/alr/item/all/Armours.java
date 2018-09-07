package com.dakoda.alr.item.all;

import com.dakoda.alr.item.equip.armour.Armour;

public enum Armours {

    ;

    private final Armour item;

    Armours(
            Armour item
    ) {
        this.item = item;
    }

    public Armour get() {
        return item;
    }
}
