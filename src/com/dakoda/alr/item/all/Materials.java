package com.dakoda.alr.item.all;

import com.dakoda.alr.item.craft.CraftingMaterial;

public enum Materials {

    ;

    private final CraftingMaterial item;

    Materials(
            CraftingMaterial item
    ) {
        this.item = item;
    }

    public CraftingMaterial get() {
        return item;
    }

}
