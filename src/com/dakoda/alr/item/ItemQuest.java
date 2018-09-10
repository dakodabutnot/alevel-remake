package com.dakoda.alr.item;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.QUEST;

public class ItemQuest extends Item {

    public ItemQuest(String name, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name);
    }

    public ItemQuest(String name) {
        setMoneyValue(1);
        defaulted(name);
    }

    private void defaulted(String name) {
        setName(name);
        setItemType(QUEST);
    }

    public String getDescription() {
        return "This item is required for a quest.";
    }
}
