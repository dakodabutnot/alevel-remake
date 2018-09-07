package com.dakoda.alr.item.all;

import com.dakoda.alr.item.misc.junk.ItemJunk;

public enum Junk {

    ;

    private final ItemJunk item;

    Junk(
            ItemJunk item
    ) {
        this.item = item;
    }

    public ItemJunk get() {
        return item;
    }
}
