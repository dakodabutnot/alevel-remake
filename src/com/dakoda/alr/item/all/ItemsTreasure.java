package com.dakoda.alr.item.all;

import com.dakoda.alr.item.misc.treasure.ItemTreasure;

public enum ItemsTreasure {

    ;

    private final ItemTreasure item;

    ItemsTreasure (
            ItemTreasure item
    ) {
        this.item = item;
    }

    public ItemTreasure get() {
        return item;
    }
}
