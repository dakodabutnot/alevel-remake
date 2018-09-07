package com.dakoda.alr.item.all;

import com.dakoda.alr.item.misc.treasure.ItemTreasure;

public enum Treasures {

    ;

    private final ItemTreasure item;

    Treasures(
            ItemTreasure item
    ) {
        this.item = item;
    }

    public ItemTreasure get() {
        return item;
    }
}
