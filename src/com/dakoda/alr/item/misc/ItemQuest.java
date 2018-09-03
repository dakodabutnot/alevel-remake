package com.dakoda.alr.item.misc;
import com.dakoda.alr.game.quest.Quest;
import com.dakoda.alr.item.Item;

import static com.dakoda.alr.item.ItemType.QUEST;

public class ItemQuest extends Item {

    private Quest quest;

    public ItemQuest(String name, Quest quest, int moneyValue) {
        setMoneyValue(moneyValue);
        defaulted(name, quest);
    }

    public ItemQuest(String name, Quest quest) {
        setMoneyValue(1);
        defaulted(name, quest);
    }

    private void defaulted(String name, Quest quest) {
        setName(name);
        setItemType(QUEST);
        this.quest = quest;
    }

    public Quest getRelatedQuest() {
        return quest;
    }

    protected String getDescription() {
        return "This item is required for a quest.";
    }
}
