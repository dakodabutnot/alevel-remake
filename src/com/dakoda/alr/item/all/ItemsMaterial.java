package com.dakoda.alr.item.all;

import com.dakoda.alr.item.craft.CraftingMaterial;

public enum ItemsMaterial {

    ;

    private final CraftingMaterial item;

    ItemsMaterial(
            CraftingMaterial item
    ) {
        this.item = item;
    }

    public CraftingMaterial get() {
        return item;
    }

}
