package com.dakoda.alr.item.all;

import com.dakoda.alr.item.equip.weapon.Weapon;

public enum ItemsWeapon {

    ;

    private final Weapon item;

    ItemsWeapon (
            Weapon item
    ) {
        this.item = item;
    }

    public Weapon get() {
        return item;
    }
}
