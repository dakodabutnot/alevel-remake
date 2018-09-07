package com.dakoda.alr.item.all;
import com.dakoda.alr.item.misc.quest.ItemQuest;

public enum QuestItems {

    APPLE(new ItemQuest("Apple"));

    private final ItemQuest item;

    QuestItems(
            ItemQuest item
    ) {
        this.item = item;
    }

    public ItemQuest get() {
        return item;
    }
}
