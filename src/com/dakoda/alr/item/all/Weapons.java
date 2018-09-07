package com.dakoda.alr.item.all;

import com.dakoda.alr.item.equip.weapon.Weapon;

public enum Weapons {

    ;

    private final Weapon item;

    Weapons(
            Weapon item
    ) {
        this.item = item;
    }

    public Weapon get() {
        return item;
    }
}
