package com.dakoda.alr.item.all;

import com.dakoda.alr.item.misc.junk.ItemJunk;

public enum ItemsJunk {

    ;

    private final ItemJunk item;

    ItemsJunk(
            ItemJunk item
    ) {
        this.item = item;
    }

    public ItemJunk get() {
        return item;
    }
}
