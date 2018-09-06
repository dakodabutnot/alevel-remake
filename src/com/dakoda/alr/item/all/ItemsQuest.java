package com.dakoda.alr.item.all;

import com.dakoda.alr.item.misc.quest.ItemQuest;

public enum ItemsQuest {

    ;

    private final ItemQuest item;

    ItemsQuest(
            ItemQuest item
    ) {
        this.item = item;
    }

    public ItemQuest get() {
        return item;
    }
}
